package br.com.myFavoriteMovies.movies.request;

import br.com.myFavoriteMovies.movies.dto.factory.SectionDataDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequest {
    private String title;
    private String director;
    private String poster;
    private String releaseDate;
    private String duration;
    private String genre;
    private List<SectionDataDTO> article;
}
