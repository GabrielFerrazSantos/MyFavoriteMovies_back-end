package br.com.myFavoriteMovies.movies.repository;

import br.com.myFavoriteMovies.movies.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<TagEntity, Long> {
    List<TagEntity> findAllByNewsId(long newsId);
}
