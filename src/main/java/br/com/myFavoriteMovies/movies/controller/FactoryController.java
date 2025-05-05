package br.com.myFavoriteMovies.movies.controller;

import br.com.myFavoriteMovies.movies.dto.factory.FactoryDTO;
import br.com.myFavoriteMovies.movies.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api/v1")
public class FactoryController {
    @Autowired
    private FactoryService service;

    @GetMapping(value = "/factory/news/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<FactoryDTO> getNewsById(@PathVariable(value = "id") Long id) throws IOException {
        return service.getNewsById(id);
    }

    @GetMapping(value = "/factory/movie/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<FactoryDTO> getMovieById(@PathVariable(value = "id") Long id) throws IOException {
        return service.getMovieById(id);
    }
}
