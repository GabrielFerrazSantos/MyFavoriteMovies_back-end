package br.com.myFavoriteMovies.movies.controller;

import br.com.myFavoriteMovies.movies.dto.MovieDTO;
import br.com.myFavoriteMovies.movies.request.MovieRequest;
import br.com.myFavoriteMovies.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class MovieController {
    @Autowired
    private MovieService service;

    @GetMapping(value = "/movie")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        return service.getAllMovies();
    }

    @GetMapping(value = "/movie/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable(value = "id") Long id) {
        return service.getMovieById(id);
    }

    @PostMapping(value = "/movie")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieRequest movieRequest) {
        return service.createMovie(movieRequest);
    }
}
