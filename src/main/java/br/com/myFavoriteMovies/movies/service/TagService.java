package br.com.myFavoriteMovies.movies.service;

import br.com.myFavoriteMovies.movies.dto.UniqueTagsDTO;
import br.com.myFavoriteMovies.movies.entity.TagEntity;
import br.com.myFavoriteMovies.movies.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    @Autowired
    private TagRepository repository;

    public ResponseEntity<UniqueTagsDTO> getAllUniqueTags() {
        return ResponseEntity.ok(new UniqueTagsDTO(repository
                .findAll()
                .stream()
                .map(TagEntity::getName)
                .distinct()
                .toList()));
    }
}
