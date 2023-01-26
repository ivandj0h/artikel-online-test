package ivandjoh.com.livecode.entity;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArtikelPost {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    private String createdAt;
    private String updatedAt;

    @ManyToAny(cascade = CascadeType.ALL)
    @JoinTable(
        name = "artikel_category",
        joinColumns = {@JoinColumn(name = "artikel_id")},
        inverseJoinColumns = {@JoinColumn(name = "category_id")}
        )

    @JsonProperty("artikel_category")
    public List<ArtikelCategory> artikelCategories;

    @ManyToAny(cascade = CascadeType.ALL)
    @JoinTable(
        name = "artikel_tag",
        joinColumns = {@JoinColumn(name = "artikel_id")},
        inverseJoinColumns = {@JoinColumn(name = "tag_id")}
        )
    
    @JsonProperty("artikel_tag")
    public List<ArtikelTag> artikelTags;

    @JsonGetter("artikel_category")
    public List<String> getAllWList() {
        if(artikelCategories != null) {
            return artikelCategories.stream()
            .map(ac -> {
                return "/categories/" + ac.getId();
            }).collect(Collectors.toList());
        }
        return null;
    }

    public List<String> getAllWLists() {
        if(artikelTags != null) {
            return artikelTags.stream()
            .map(at -> {
                return "/tags/" + at.getId();
            }).collect(Collectors.toList());
        }
        return null;
    }

}
