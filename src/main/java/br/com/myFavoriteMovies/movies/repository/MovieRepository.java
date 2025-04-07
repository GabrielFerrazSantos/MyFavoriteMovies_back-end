package br.com.myFavoriteMovies.movies.repository;

import br.com.myFavoriteMovies.movies.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
}
