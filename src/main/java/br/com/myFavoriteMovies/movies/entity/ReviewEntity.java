package br.com.myFavoriteMovies.movies.entity;

import br.com.myFavoriteMovies.movies.request.ReviewRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_review")
public class ReviewEntity {
    public ReviewEntity(ReviewRequest reviewRequest) {
        this.movieId = reviewRequest.getMovieId();
        this.userId = reviewRequest.getUserId();
        this.review = reviewRequest.getReview();
        this.score = reviewRequest.getScore();
        this.date = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "movie_id")
    private long movieId;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "review")
    private String review;

    @Column(name = "score")
    private int score;

    @Column(name = "date")
    private LocalDateTime date;
}
