package br.com.myFavoriteMovies.movies.controller;

import br.com.myFavoriteMovies.movies.dto.ProfileActivityDTO;
import br.com.myFavoriteMovies.movies.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class ProfileController {
    @Autowired
    private ProfileService service;

    @GetMapping(value = "/profile/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ProfileActivityDTO>> getProfileActivitiesByUserId(@PathVariable(value = "id") Long id) {
        return service.getProfileActivitiesByUserId(id);
    }
}
