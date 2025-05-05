package br.com.myFavoriteMovies.movies.service;

import br.com.myFavoriteMovies.movies.dto.NewsDTO;
import br.com.myFavoriteMovies.movies.entity.NewsEntity;
import br.com.myFavoriteMovies.movies.entity.TagEntity;
import br.com.myFavoriteMovies.movies.repository.NewsRepository;

import br.com.myFavoriteMovies.movies.repository.TagRepository;
import br.com.myFavoriteMovies.movies.request.NewsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private TagRepository tagRepository;

    public ResponseEntity<List<NewsDTO>> getAllNews() {
        var newsDTOs = newsRepository
                .findAllByOrderByDateDesc()
                .stream()
                .map(value -> {
                    try {
                        return new NewsDTO(value);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();

        newsDTOs.forEach(news -> {
            news.setTags(tagRepository
                    .findAllByNewsId(news.getId())
                    .stream()
                    .map(TagEntity::getName)
                    .toList());
        });

        return ResponseEntity.ok(newsDTOs);
    }

    public ResponseEntity<NewsDTO> getNewsById(long id) throws IOException {
        var newsEntity = newsRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
        var newsDTO = new NewsDTO(newsEntity);

        newsDTO.setTags(tagRepository
                .findAllByNewsId(newsDTO.getId())
                .stream()
                .map(TagEntity::getName)
                .toList());

        return ResponseEntity.ok(newsDTO);
    }

    public ResponseEntity<NewsDTO> createNews(NewsRequest newsRequest) {
        try {
            var newsEntity = newsRepository.save(new NewsEntity(newsRequest));

            var tagEntitys = tagRepository
                    .saveAll(newsRequest
                            .getTags()
                            .stream()
                            .map(tag -> new TagEntity(newsEntity.getId(), tag))
                            .toList());

            var newsDTO = new NewsDTO(newsEntity);

            newsDTO.setTags(tagEntitys
                    .stream()
                    .map(TagEntity::getName)
                    .toList());

            return ResponseEntity.ok(newsDTO);
        } catch (Exception e) {
            return ResponseEntity
                    .unprocessableEntity()
                    .build();
        }
    }
}
