package br.com.myFavoriteMovies.movies.dto;

import br.com.myFavoriteMovies.movies.entity.MovieEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    public MovieDTO(MovieEntity movieEntity) {
        this.id = movieEntity.getId();
        this.title = movieEntity.getTitle();
        this.director = movieEntity.getDirector();
        this.storyline = movieEntity.getStoryline();
        this.poster = movieEntity.getPoster();
        this.releaseDate = movieEntity.getReleaseDate().toString();
        this.duration = movieEntity.getDuration();
        this.genre = movieEntity.getGenre();
    }

    private int id;
    private String title;
    private String director;
    private String storyline;
    private String poster;
    private String releaseDate;
    private String duration;
    private String genre;
}
