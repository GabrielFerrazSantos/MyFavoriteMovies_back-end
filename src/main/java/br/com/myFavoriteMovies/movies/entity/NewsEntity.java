package br.com.myFavoriteMovies.movies.entity;

import br.com.myFavoriteMovies.movies.request.NewsRequest;
import br.com.myFavoriteMovies.movies.utils.JsonUtils;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_news")
public class NewsEntity {
    public NewsEntity (NewsRequest newsRequest) throws IOException {
        this.title = newsRequest.getTitle();
        this.headline = newsRequest.getHeadline();
        this.image = newsRequest.getImage();
        this.date = LocalDateTime.now();
        this.article = JsonUtils.toJsonByteArray(newsRequest.getArticle());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "headline")
    private String headline;

    @Column(name = "image")
    private String image;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "article")
    private byte[] article;
}
