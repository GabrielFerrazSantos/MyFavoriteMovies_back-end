package br.com.myFavoriteMovies.movies.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentaryRequest {
    private long newsId;
    private long userId;
    private String commentary;
}
