package br.com.myFavoriteMovies.movies.service;

import br.com.myFavoriteMovies.movies.dto.ReviewDTO;
import br.com.myFavoriteMovies.movies.dto.UserDTO;
import br.com.myFavoriteMovies.movies.entity.ReviewEntity;
import br.com.myFavoriteMovies.movies.entity.UserEntity;
import br.com.myFavoriteMovies.movies.repository.ReviewRepository;
import br.com.myFavoriteMovies.movies.request.ReviewRequest;
import br.com.myFavoriteMovies.movies.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    public ReviewRepository repository;

    public ResponseEntity<List<ReviewDTO>> getAllReviewsFromMovieByMovieId(long id) {
        return ResponseEntity.ok(repository
                .findAllByMovieIdOrderByDateDesc(id)
                .stream()
                .map(ReviewDTO::new)
                .toList());
    }

    public ResponseEntity<ReviewDTO> createReview(ReviewRequest reviewRequest) {
        try {
            var reviewEntity = repository.save(new ReviewEntity(reviewRequest));

            return ResponseEntity.ok(new ReviewDTO(reviewEntity));
        } catch (Exception e) {
            return ResponseEntity
                    .unprocessableEntity()
                    .build();
        }
    }
}
