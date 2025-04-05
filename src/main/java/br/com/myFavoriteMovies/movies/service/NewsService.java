package br.com.myFavoriteMovies.movies.service;

import br.com.myFavoriteMovies.movies.dto.NewsDTO;
import br.com.myFavoriteMovies.movies.repository.NewsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class NewsService {

    @Autowired
    private NewsRepository repository;

    public ResponseEntity<List<NewsDTO>> getAllNews() {
        var newsDTOs = repository.findAll().stream()
                .map(NewsDTO::new)
                .toList();

        return ResponseEntity.ok(newsDTOs);
    }
}
