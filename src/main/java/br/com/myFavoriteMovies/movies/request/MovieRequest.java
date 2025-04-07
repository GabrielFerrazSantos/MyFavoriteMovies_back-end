package br.com.myFavoriteMovies.movies.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequest {
    private String title;
    private String director;
    private String storyline;
    private String poster;
    private String releaseDate;
    private String duration;
    private String genre;
}
