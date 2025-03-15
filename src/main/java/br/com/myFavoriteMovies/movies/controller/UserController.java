package br.com.myFavoriteMovies.movies.controller;

import br.com.myFavoriteMovies.movies.dto.UserDTO;
import br.com.myFavoriteMovies.movies.request.UserRequest;
import br.com.myFavoriteMovies.movies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping(value = "/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserDTO> getUser(@PathVariable(value = "id") Long id) {
        return service.getUserById(id);
    }

    @PostMapping(value = "/user")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserRequest userRequest) {
        return service.createUser(userRequest);
    }
}
