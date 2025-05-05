package br.com.myFavoriteMovies.movies.dto;

import br.com.myFavoriteMovies.movies.dto.factory.SectionDataDTO;
import br.com.myFavoriteMovies.movies.entity.MovieEntity;
import br.com.myFavoriteMovies.movies.utils.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    public MovieDTO(MovieEntity movieEntity) throws IOException {
        this.id = movieEntity.getId();
        this.title = movieEntity.getTitle();
        this.director = movieEntity.getDirector();
        this.poster = movieEntity.getPoster();
        this.releaseDate = movieEntity.getReleaseDate().toString();
        this.duration = movieEntity.getDuration();
        this.genre = movieEntity.getGenre();
        this.article = JsonUtils.fromJsonByteArray(movieEntity.getArticle(), new TypeReference<List<SectionDataDTO>>() {});
    }

    private long id;
    private String title;
    private String director;
    private String poster;
    private String releaseDate;
    private String duration;
    private String genre;
    private List<SectionDataDTO> article;
}
