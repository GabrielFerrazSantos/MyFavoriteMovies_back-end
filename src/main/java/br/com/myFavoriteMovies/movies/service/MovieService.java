package br.com.myFavoriteMovies.movies.service;

import br.com.myFavoriteMovies.movies.dto.MovieDTO;
import br.com.myFavoriteMovies.movies.entity.MovieEntity;
import br.com.myFavoriteMovies.movies.repository.MovieRepository;
import br.com.myFavoriteMovies.movies.request.MovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        return ResponseEntity.ok(movieRepository.findAll().stream().map(MovieDTO::new).toList());
    }

    public ResponseEntity<MovieDTO> getMovieById(Long id) {
        return movieRepository
                .findById(id)
                .map(value -> ResponseEntity.ok(new MovieDTO(value)))
                .orElseGet(() -> ResponseEntity
                        .noContent()
                        .build());
    }

    public ResponseEntity<MovieDTO> createMovie(MovieRequest movieRequest) {
        try {
            return ResponseEntity.ok(new MovieDTO(movieRepository.save(new MovieEntity(movieRequest))));
        } catch (Exception e) {
            return ResponseEntity
                    .unprocessableEntity()
                    .build();
        }
    }
}
