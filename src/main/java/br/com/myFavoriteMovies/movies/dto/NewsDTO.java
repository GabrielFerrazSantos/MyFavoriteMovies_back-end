package br.com.myFavoriteMovies.movies.dto;

import br.com.myFavoriteMovies.movies.entity.NewsEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsDTO {

    public NewsDTO(NewsEntity newsEntity) {
        this.id = newsEntity.getId();
        this.title = newsEntity.getTitle();
        this.description = newsEntity.getDescription();
        this.image = newsEntity.getImage();
        this.date = newsEntity.getDate();
    }

    private int id;
    private String title;
    private String description;
    private byte[] image;
    private String date;
}
