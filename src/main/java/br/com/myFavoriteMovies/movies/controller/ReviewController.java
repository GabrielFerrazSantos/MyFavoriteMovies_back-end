package br.com.myFavoriteMovies.movies.controller;

import br.com.myFavoriteMovies.movies.dto.ReviewDTO;
import br.com.myFavoriteMovies.movies.request.ReviewRequest;
import br.com.myFavoriteMovies.movies.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class ReviewController {
    @Autowired
    private ReviewService service;

    @GetMapping(value = "/review/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ReviewDTO>> getAllReviewsFromMovieByMovieId(@PathVariable(value = "id") Long id) {
        return service.getAllReviewsFromMovieByMovieId(id);
    }

    @PostMapping(value = "/review")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ReviewDTO> createReview(@RequestBody ReviewRequest reviewRequest) {
        return service.createReview(reviewRequest);
    }
}
