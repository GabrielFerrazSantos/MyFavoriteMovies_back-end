package br.com.myFavoriteMovies.movies.entity;

import br.com.myFavoriteMovies.movies.request.NewsRequest;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_news")
public class NewsEntity {
    public NewsEntity (NewsRequest newsRequest) {
        this.title = newsRequest.getTitle();
        this.description = newsRequest.getDescription();
        this.body = newsRequest.getBody();
        this.image = newsRequest.getImage();
        this.date = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "body")
    private String body;

    @Column(name = "image")
    private String image;

    @Column(name = "date")
    private LocalDateTime date;
}
