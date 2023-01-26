package ivandjoh.com.livecode.entity;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class ArtikelTag {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "artikelTags")
    List<ArtikelPost> artikelPosts;

    public List<String> getAllArtikelPosts() {
        if(artikelPosts != null) {
            return artikelPosts.stream()
            .map(ap -> {
                return "/posts" + ap.getId();
            }).collect(Collectors.toList());
        }
        return null;
    }
}
