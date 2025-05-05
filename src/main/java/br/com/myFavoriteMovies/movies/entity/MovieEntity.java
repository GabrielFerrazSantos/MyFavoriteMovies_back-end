package br.com.myFavoriteMovies.movies.entity;

import br.com.myFavoriteMovies.movies.request.MovieRequest;
import br.com.myFavoriteMovies.movies.utils.JsonUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_movie")
public class MovieEntity {
    public MovieEntity (MovieRequest movieRequest) throws ParseException, IOException {
        var formatter = new SimpleDateFormat("yyyy-MM-dd");

        this.title = movieRequest.getTitle();
        this.director = movieRequest.getDirector();
        this.poster = movieRequest.getPoster();
        this.releaseDate = formatter.parse(movieRequest.getReleaseDate());
        this.duration = movieRequest.getDuration();
        this.genre = movieRequest.getGenre();
        this.article = JsonUtils.toJsonByteArray(movieRequest.getArticle());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "director")
    private String director;

    @Column(name = "poster")
    private String poster;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "duration")
    private String duration;

    @Column(name = "genre")
    private String genre;

    @Column(name = "article")
    private byte[] article;
}
