package br.com.myFavoriteMovies.movies.dto.factory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectionDTO {
    public String type;
    public List<SectionDataDTO> data;
}
