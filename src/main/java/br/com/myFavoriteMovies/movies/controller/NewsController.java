package br.com.myFavoriteMovies.movies.controller;

import br.com.myFavoriteMovies.movies.dto.NewsDTO;
import br.com.myFavoriteMovies.movies.request.NewsRequest;
import br.com.myFavoriteMovies.movies.service.NewsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class NewsController {
    @Autowired
    private NewsService service;

    @GetMapping(value = "/news")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<NewsDTO>> getAllNews() {
        return service.getAllNews();
    }

    @GetMapping(value = "/news/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<NewsDTO> getNewsById(@PathVariable(value = "id") Long id) throws IOException {
        return service.getNewsById(id);
    }

    @PostMapping(value = "/news")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<NewsDTO> createNews(@RequestBody NewsRequest newsRequest) {
        return service.createNews(newsRequest);
    }
}
