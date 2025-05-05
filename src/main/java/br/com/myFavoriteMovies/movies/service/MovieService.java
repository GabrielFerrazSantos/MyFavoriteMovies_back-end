package br.com.myFavoriteMovies.movies.service;

import br.com.myFavoriteMovies.movies.dto.MovieDTO;
import br.com.myFavoriteMovies.movies.entity.MovieEntity;
import br.com.myFavoriteMovies.movies.repository.MovieRepository;
import br.com.myFavoriteMovies.movies.request.MovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        return ResponseEntity.ok(movieRepository.findAll().stream().map(value -> {
            try {
                return new MovieDTO(value);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).toList());
    }

    public ResponseEntity<MovieDTO> getMovieById(Long id) {
        return movieRepository
                .findById(id)
                .map(value -> {
                    try {
                        return ResponseEntity.ok(new MovieDTO(value));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
    }

    public ResponseEntity<MovieDTO> createMovie(MovieRequest movieRequest) {
        try {
            var movieEntity = movieRepository.save(new MovieEntity(movieRequest));
            var movieDTO = new MovieDTO(movieEntity);

            return ResponseEntity.ok(movieDTO);
        } catch (Exception e) {
            return ResponseEntity
                    .unprocessableEntity()
                    .build();
        }
    }
}
