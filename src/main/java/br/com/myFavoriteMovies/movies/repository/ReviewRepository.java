package br.com.myFavoriteMovies.movies.repository;

import br.com.myFavoriteMovies.movies.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    List<ReviewEntity> findAllByMovieIdOrderByDateDesc(long id);
    List<ReviewEntity> findAllByUserIdOrderByDateDesc(long id);
}
