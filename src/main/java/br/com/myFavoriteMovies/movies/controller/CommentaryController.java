package br.com.myFavoriteMovies.movies.controller;

import br.com.myFavoriteMovies.movies.dto.CommentaryDTO;
import br.com.myFavoriteMovies.movies.request.CommentaryRequest;
import br.com.myFavoriteMovies.movies.service.CommentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class CommentaryController {
    @Autowired
    private CommentaryService service;

    @GetMapping(value = "/commentary/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CommentaryDTO>> getAllReviewsFromMovieByMovieId(@PathVariable(value = "id") Long id) {
        return service.getAllCommentariesFromNewsByNewsId(id);
    }

    @PostMapping(value = "/commentary")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CommentaryDTO> createReview(@RequestBody CommentaryRequest commentaryRequest) {
        return service.createCommentary(commentaryRequest);
    }
}
