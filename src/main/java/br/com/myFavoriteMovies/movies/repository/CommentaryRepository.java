package br.com.myFavoriteMovies.movies.repository;

import br.com.myFavoriteMovies.movies.entity.CommentaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentaryRepository extends JpaRepository<CommentaryEntity, Long> {
    List<CommentaryEntity> findAllByNewsIdOrderByDateDesc(long id);
}
