package br.com.myFavoriteMovies.movies.repository;

import br.com.myFavoriteMovies.movies.entity.NewsEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NewsRepository extends JpaRepository<NewsEntity, Long> {
    Optional<NewsEntity> findById(long id);
    List<NewsEntity> findAllByOrderByDateDesc();
}
