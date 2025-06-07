package br.com.myFavoriteMovies.movies.service;

import br.com.myFavoriteMovies.movies.dto.CommentaryDTO;
import br.com.myFavoriteMovies.movies.dto.ProfileActivityDTO;
import br.com.myFavoriteMovies.movies.dto.ReviewDTO;
import br.com.myFavoriteMovies.movies.repository.CommentaryRepository;
import br.com.myFavoriteMovies.movies.repository.MovieRepository;
import br.com.myFavoriteMovies.movies.repository.NewsRepository;
import br.com.myFavoriteMovies.movies.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ProfileService {
    @Autowired
    private CommentaryRepository commentaryRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private MovieRepository movieRepository;

    public ResponseEntity<List<ProfileActivityDTO>> getProfileActivitiesByUserId(long id) {
        var commentariesDTO = commentaryRepository
                .findAllByUserIdOrderByDateDesc(id)
                .stream()
                .map(CommentaryDTO::new);

        var reviewsDTO = reviewRepository
                .findAllByUserIdOrderByDateDesc(id)
                .stream()
                .map(ReviewDTO::new);

        List<ProfileActivityDTO> profileActivitiesDTO = new ArrayList<ProfileActivityDTO>();

        commentariesDTO.forEach(value -> {
            var title = newsRepository
                    .findById(value.getNewsId())
                    .get()
                    .getTitle();

            profileActivitiesDTO.add(new ProfileActivityDTO(value, title));
        });

        reviewsDTO.forEach(value -> {
            var title = movieRepository
                    .findById(value.getMovieId())
                    .get()
                    .getTitle();

            profileActivitiesDTO.add(new ProfileActivityDTO(value, title));
        });

        profileActivitiesDTO.sort(Comparator.comparing(ProfileActivityDTO::getDateTime).reversed());
        
        return ResponseEntity.ok(profileActivitiesDTO);
    }
}
