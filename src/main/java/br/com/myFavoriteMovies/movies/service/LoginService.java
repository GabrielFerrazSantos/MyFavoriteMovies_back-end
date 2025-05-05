package br.com.myFavoriteMovies.movies.service;

import br.com.myFavoriteMovies.movies.dto.UserDTO;
import br.com.myFavoriteMovies.movies.repository.UserRepository;
import br.com.myFavoriteMovies.movies.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LoginService {
    @Autowired
    private UserRepository repository;
    
    public ResponseEntity<UserDTO> validateLogin(LoginRequest loginRequest) {
        var user = repository
                .findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY));

        if (loginRequest.getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok(new UserDTO(user));
        } else {
            return ResponseEntity
                    .unprocessableEntity()
                    .build();
        }
    }
}
