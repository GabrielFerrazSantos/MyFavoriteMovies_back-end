package br.com.myFavoriteMovies.movies.service;

import br.com.myFavoriteMovies.movies.dto.UserDTO;
import br.com.myFavoriteMovies.movies.entity.UserEntity;
import br.com.myFavoriteMovies.movies.repository.UserRepository;
import br.com.myFavoriteMovies.movies.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public ResponseEntity<UserDTO> getUserById(Long id) {
        return repository
                .findById(id)
                .map(value -> ResponseEntity.ok(new UserDTO(value)))
                .orElseGet(() -> ResponseEntity
                        .noContent()
                        .build());
    }

    public ResponseEntity<UserDTO> createUser(UserRequest userRequest) {
        try {
            repository.save(new UserEntity(userRequest));

            return ResponseEntity.ok(new UserDTO(repository
                    .findByUsername(userRequest
                            .getUsername())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY))));
        } catch (Exception e) {
            return ResponseEntity
                    .unprocessableEntity()
                    .build();
        }
    }
}
