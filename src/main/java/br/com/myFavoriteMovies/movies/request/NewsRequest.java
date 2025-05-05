package br.com.myFavoriteMovies.movies.request;

import br.com.myFavoriteMovies.movies.dto.factory.SectionDataDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsRequest {
    private String title;
    private String headline;
    private String image;
    private List<String> tags;
    private List<SectionDataDTO> article;
}
