package br.com.myFavoriteMovies.movies.entity;

import br.com.myFavoriteMovies.movies.request.CommentaryRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_commentary")
public class CommentaryEntity {
    public CommentaryEntity(CommentaryRequest commentaryRequest) {
        this.newsId = commentaryRequest.getNewsId();
        this.userId = commentaryRequest.getUserId();
        this.commentary = commentaryRequest.getCommentary();
        this.date = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "news_id")
    private long newsId;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "commentary")
    private String commentary;

    @Column(name = "date")
    private LocalDateTime date;
}
