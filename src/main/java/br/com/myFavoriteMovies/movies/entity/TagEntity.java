package br.com.myFavoriteMovies.movies.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_tag")
public class TagEntity {
    public TagEntity(long newsId, String tag) {
        this.newsId = newsId;
        this.name = tag;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "news_id")
    private long newsId;

    @Column(name = "name")
    private String name;
}
