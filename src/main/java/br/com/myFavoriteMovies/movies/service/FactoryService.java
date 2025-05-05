package br.com.myFavoriteMovies.movies.service;

import br.com.myFavoriteMovies.movies.dto.CommentaryDTO;
import br.com.myFavoriteMovies.movies.dto.ReviewDTO;
import br.com.myFavoriteMovies.movies.dto.factory.FactoryDTO;
import br.com.myFavoriteMovies.movies.dto.factory.SectionDTO;
import br.com.myFavoriteMovies.movies.dto.factory.SectionDataDTO;
import br.com.myFavoriteMovies.movies.entity.CommentaryEntity;
import br.com.myFavoriteMovies.movies.entity.ReviewEntity;
import br.com.myFavoriteMovies.movies.repository.*;
import br.com.myFavoriteMovies.movies.utils.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
public class FactoryService {
    private static final String SECTION_ARTICLE = "article";
    private static final String SECTION_COMMENTARIES = "commentaries";
    private static final String SECTION_REVIEWS = "reviews";

    private static final String ITEM_WRITE_COMMENTARY = "writeCommentary";
    private static final String ITEM_COMMENTARY = "commentary";
    private static final String ITEM_WRITE_REVIEW = "writeReview";
    private static final String ITEM_REVIEW = "review";

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentaryRepository commentaryRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    public ResponseEntity<FactoryDTO> getNewsById(long id) throws IOException {
        var news = newsRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));

        var articleData = JsonUtils.fromJsonByteArray(news.getArticle(), new TypeReference<List<SectionDataDTO>>() {});

        var commentaries = commentaryRepository.findAllByNewsIdOrderByDateDesc(id);
        var commentariesData = buildSectionDataWithUsernames(
                commentaries,
                ITEM_WRITE_COMMENTARY,
                ITEM_COMMENTARY,
                CommentaryDTO::new
        );

        var sections = List.of(
                new SectionDTO(SECTION_ARTICLE, articleData),
                new SectionDTO(SECTION_COMMENTARIES, commentariesData)
        );

        return ResponseEntity.ok(new FactoryDTO(sections));
    }

    public ResponseEntity<FactoryDTO> getMovieById(long id) throws IOException {
        var movie = movieRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));

        var articleData = JsonUtils.fromJsonByteArray(movie.getArticle(), new TypeReference<List<SectionDataDTO>>() {});

        var reviews = reviewRepository.findAllByMovieIdOrderByDateDesc(id);
        var reviewsData = buildSectionDataWithUsernames(
                reviews,
                ITEM_WRITE_REVIEW,
                ITEM_REVIEW,
                ReviewDTO::new
        );

        var sections = List.of(
                new SectionDTO(SECTION_ARTICLE, articleData),
                new SectionDTO(SECTION_REVIEWS, reviewsData)
        );

        return ResponseEntity.ok(new FactoryDTO(sections));
    }

    private <E, D> List<SectionDataDTO> buildSectionDataWithUsernames(List<E> entities, String writeLabel, String itemLabel, Function<E, D> dtoMapper) {
        var result = new ArrayList<SectionDataDTO>();
        result.add(new SectionDataDTO(writeLabel, null));

        List<SectionDataDTO> dataWithUsernames = entities.stream()
                .map(entity -> {
                    Long userId = getUserId(entity);
                    var user = userRepository.findById(userId).orElseThrow();
                    D dto = dtoMapper.apply(entity);
                    setUsername(dto, user.getUsername());
                    return new SectionDataDTO(itemLabel, dto);
                })
                .toList();

        result.addAll(dataWithUsernames);
        return result;
    }

    private Long getUserId(Object entity) {
        if (entity instanceof CommentaryEntity commentary) {
            return commentary.getUserId();
        } else if (entity instanceof ReviewEntity review) {
            return review.getUserId();
        }
        throw new IllegalArgumentException("Unsupported entity type: " + entity.getClass());
    }

    private void setUsername(Object dto, String username) {
        if (dto instanceof CommentaryDTO commentaryDTO) {
            commentaryDTO.setUsername(username);
        } else if (dto instanceof ReviewDTO reviewDTO) {
            reviewDTO.setUsername(username);
        } else {
            throw new IllegalArgumentException("Unsupported DTO type: " + dto.getClass());
        }
    }
}
