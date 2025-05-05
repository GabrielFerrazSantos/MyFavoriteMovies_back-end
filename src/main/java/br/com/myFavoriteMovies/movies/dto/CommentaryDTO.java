package br.com.myFavoriteMovies.movies.dto;

import br.com.myFavoriteMovies.movies.entity.CommentaryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentaryDTO {
    public CommentaryDTO(CommentaryEntity commentaryEntity) {
        this.id = commentaryEntity.getId();
        this.newsId = commentaryEntity.getNewsId();
        this.userId = commentaryEntity.getUserId();
        this.username = null;
        this.commentary = commentaryEntity.getCommentary();
        this.date = commentaryEntity.getDate();
    }

    private long id;
    private long newsId;
    private long userId;
    private String username;
    private String commentary;
    private LocalDateTime date;
}
