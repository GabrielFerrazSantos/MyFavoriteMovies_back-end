package br.com.myFavoriteMovies.movies.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileActivityDTO {
    public ProfileActivityDTO(CommentaryDTO commentaryDTO, String title) {
        this.title = title;
        this.description = commentaryDTO.getCommentary();
        this.dateTime = commentaryDTO.getDate();
    }

    public ProfileActivityDTO(ReviewDTO reviewDTO, String title) {
        this.title = title;
        this.description = reviewDTO.getReview();
        this.score = reviewDTO.getScore();
        this.dateTime = reviewDTO.getDate();
    }

    private String title;
    private String description;
    private Long score;
    private LocalDateTime dateTime;
}
