package br.com.myFavoriteMovies.movies.controller;

import br.com.myFavoriteMovies.movies.dto.UserDTO;
import br.com.myFavoriteMovies.movies.request.LoginRequest;
import br.com.myFavoriteMovies.movies.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class LoginController {
    @Autowired
    private LoginService service;

    @PostMapping(value = "/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserDTO> login(@RequestBody LoginRequest loginRequest) {
        return service.validateLogin(loginRequest);
    }
}
