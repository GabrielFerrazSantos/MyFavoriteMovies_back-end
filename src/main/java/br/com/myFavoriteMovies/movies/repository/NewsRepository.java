package br.com.myFavoriteMovies.movies.repository;

import br.com.myFavoriteMovies.movies.entity.NewsEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<NewsEntity, Long> {
}
