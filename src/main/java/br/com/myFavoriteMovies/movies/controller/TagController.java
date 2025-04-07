package br.com.myFavoriteMovies.movies.controller;

import br.com.myFavoriteMovies.movies.dto.UniqueTagsDTO;
import br.com.myFavoriteMovies.movies.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class TagController {
    @Autowired
    private TagService service;

    @GetMapping(value = "/tag")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UniqueTagsDTO> getAllUniqueTags() {
        return service.getAllUniqueTags();
    }
}
