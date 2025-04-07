package br.com.myFavoriteMovies.movies.service;

import br.com.myFavoriteMovies.movies.dto.NewsDTO;
import br.com.myFavoriteMovies.movies.entity.NewsEntity;
import br.com.myFavoriteMovies.movies.entity.TagEntity;
import br.com.myFavoriteMovies.movies.repository.NewsRepository;

import br.com.myFavoriteMovies.movies.repository.TagRepository;
import br.com.myFavoriteMovies.movies.request.NewsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
                .map(NewsDTO::new)
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

    public ResponseEntity<NewsDTO> getNewsById(long id) {
        var newsEntity = newsRepository.findById(id);

        if (newsEntity.isPresent()) {
            var newsDTO = new NewsDTO(newsEntity.get());

            newsDTO.setTags(tagRepository
                    .findAllByNewsId(newsDTO.getId())
                    .stream()
                    .map(TagEntity::getName)
                    .toList());

            return ResponseEntity.ok(newsDTO);
        } else {
            return ResponseEntity
                    .noContent()
                    .build();
        }
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
