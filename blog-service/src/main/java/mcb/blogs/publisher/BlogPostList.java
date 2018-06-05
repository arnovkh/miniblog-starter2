package mcb.blogs.publisher;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BlogPostList {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<BlogPost> posts;

    protected BlogPostList() {
        posts = new ArrayList<>();
        name = "";
    }

    public BlogPostList(String name) {
        this.name = name;
        posts = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<BlogPost> getItems() {
        return posts;
    }

    public void addPost(String newPost) {
    }
}
