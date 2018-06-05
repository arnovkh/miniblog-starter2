package mcb.blogs.authentication;

import mcb.blogs.publisher.BlogPost;
import mcb.blogs.publisher.BlogPostList;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("request")
public class BlogUser {
    @Id
    @GeneratedValue
    private long id;

    private String username;


    public BlogUser(String username) {
        this.username = username; posts = new ArrayList<>();
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<BlogPost> posts;

    public BlogUser() {
        posts = new ArrayList<>();

    }

    public Long getId() {
            return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }


}
