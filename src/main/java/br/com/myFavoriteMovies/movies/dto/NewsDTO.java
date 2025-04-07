package br.com.myFavoriteMovies.movies.dto;

import br.com.myFavoriteMovies.movies.entity.NewsEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Base64;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsDTO {
    public NewsDTO(NewsEntity newsEntity) {
        this.id = newsEntity.getId();
        this.title = newsEntity.getTitle();
        this.description = newsEntity.getDescription();
        this.body = newsEntity.getBody();
        this.image = newsEntity.getImage();
        this.date = newsEntity.getDate().toString();
    }

    private int id;
    private String title;
    private String description;
    private String body;
    private String image;
    private String date;
    private List<String> tags;
}
