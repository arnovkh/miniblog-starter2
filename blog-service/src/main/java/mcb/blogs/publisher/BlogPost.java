package mcb.blogs.publisher;

import mcb.blogs.authentication.BlogUser;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BlogPost {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String body;

    private BlogUser creator;

    protected BlogPost() {
    }

    public BlogPost(String title, String body) {
        this.title = title;
        this.body = body;
        this.creator= new BlogUser();
}

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public BlogUser getCreator() {
        return creator;
    }

    public void setCreator(BlogUser user) {
        this.creator=user;
    }
}
