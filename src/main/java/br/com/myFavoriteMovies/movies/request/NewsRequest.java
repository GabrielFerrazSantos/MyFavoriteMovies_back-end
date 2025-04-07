package br.com.myFavoriteMovies.movies.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsRequest {
    private String title;
    private String description;
    private String body;
    private String image;
    private List<String> tags;
}
