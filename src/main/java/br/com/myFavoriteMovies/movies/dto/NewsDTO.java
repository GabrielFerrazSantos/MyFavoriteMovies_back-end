package br.com.myFavoriteMovies.movies.dto;

import br.com.myFavoriteMovies.movies.dto.factory.SectionDataDTO;
import br.com.myFavoriteMovies.movies.entity.NewsEntity;

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
public class NewsDTO {
    public NewsDTO(NewsEntity newsEntity) throws IOException {
        this.id = newsEntity.getId();
        this.title = newsEntity.getTitle();
        this.headline = newsEntity.getHeadline();
        this.image = newsEntity.getImage();
        this.date = newsEntity.getDate().toString();
        this.article = JsonUtils.fromJsonByteArray(newsEntity.getArticle(), new TypeReference<List<SectionDataDTO>>() {});
    }

    private long id;
    private String title;
    private String headline;
    private String image;
    private String date;
    private List<String> tags;
    private List<SectionDataDTO> article;
}
