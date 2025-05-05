package br.com.myFavoriteMovies.movies.dto;

import br.com.myFavoriteMovies.movies.entity.UserEntity;
import br.com.myFavoriteMovies.movies.request.UserRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    public UserDTO(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.name = userEntity.getName();
        this.username = userEntity.getUsername();
    }

    public UserDTO(UserRequest user) {
        this.name = user.getName();
        this.username = user.getUsername();
    }

    private long id;
    private String name;
    private String username;
}
