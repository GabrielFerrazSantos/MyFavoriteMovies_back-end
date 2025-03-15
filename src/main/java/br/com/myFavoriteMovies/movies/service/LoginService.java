package br.com.myFavoriteMovies.movies.service;

import br.com.myFavoriteMovies.movies.dto.UserDTO;
import br.com.myFavoriteMovies.movies.repository.UserRepository;
import br.com.myFavoriteMovies.movies.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserRepository repository;
    
    public ResponseEntity<UserDTO> validateLogin(LoginRequest loginRequest) {
        try {
            var user = repository.findByUsername(loginRequest.getUsername());

            if (loginRequest.getPassword().equals(user.getPassword())) {
                return ResponseEntity.ok(new UserDTO(user));
            } else {
                return ResponseEntity
                        .unprocessableEntity()
                        .build();
            }
        } catch (Exception e) {
            return ResponseEntity
                    .unprocessableEntity()
                    .build();
        }
    }
}
