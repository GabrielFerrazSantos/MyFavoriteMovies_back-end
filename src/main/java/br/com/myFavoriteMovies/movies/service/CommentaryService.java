package br.com.myFavoriteMovies.movies.service;

import br.com.myFavoriteMovies.movies.dto.CommentaryDTO;
import br.com.myFavoriteMovies.movies.entity.CommentaryEntity;
import br.com.myFavoriteMovies.movies.repository.CommentaryRepository;
import br.com.myFavoriteMovies.movies.request.CommentaryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaryService {
    @Autowired
    public CommentaryRepository repository;

    public ResponseEntity<List<CommentaryDTO>> getAllCommentariesFromNewsByNewsId(long id) {
        return ResponseEntity.ok(repository
                .findAllByNewsIdOrderByDateDesc(id)
                .stream()
                .map(CommentaryDTO::new)
                .toList());
    }

    public ResponseEntity<CommentaryDTO> createCommentary(CommentaryRequest commentaryRequest) {
        try {
            var commentaryEntity = repository.save(new CommentaryEntity(commentaryRequest));

            return ResponseEntity.ok(new CommentaryDTO(commentaryEntity));
        } catch (Exception e) {
            return ResponseEntity
                    .unprocessableEntity()
                    .build();
        }
    }
}
