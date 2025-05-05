package br.com.myFavoriteMovies.movies.dto;

import br.com.myFavoriteMovies.movies.entity.ReviewEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    public ReviewDTO(ReviewEntity reviewEntity) {
        this.id = reviewEntity.getId();
        this.movieId = reviewEntity.getMovieId();
        this.userId = reviewEntity.getUserId();
        this.username = null;
        this.review = reviewEntity.getReview();
        this.score = reviewEntity.getScore();
        this.date = reviewEntity.getDate();
    }

    private long id;
    private long movieId;
    private long userId;
    private String username;
    private String review;
    private long score;
    private LocalDateTime date;
}
