package br.com.myFavoriteMovies.movies.entity;

import br.com.myFavoriteMovies.movies.request.MovieRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_movie")
public class MovieEntity {
    public MovieEntity (MovieRequest movieRequest) throws ParseException {
        var formatter = new SimpleDateFormat("yyyy-MM-dd");

        this.title = movieRequest.getTitle();
        this.director = movieRequest.getDirector();
        this.storyline = movieRequest.getStoryline();
        this.poster = movieRequest.getPoster();
        this.releaseDate = formatter.parse(movieRequest.getReleaseDate());
        this.duration = movieRequest.getDuration();
        this.genre = movieRequest.getGenre();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "director")
    private String director;

    @Column(name = "storyline")
    private String storyline;

    @Column(name = "poster")
    private String poster;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "duration")
    private String duration;

    @Column(name = "genre")
    private String genre;
}
