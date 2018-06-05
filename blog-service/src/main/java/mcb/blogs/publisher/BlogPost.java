package mcb.blogs.publisher;

import mcb.blogs.authentication.BlogUser;

import javax.persistence.*;

@Entity
public class BlogPost {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String body;

    private BlogPost parentPost;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private BlogUser creator;

    protected BlogPost() {
    }

    public BlogPost(String title, String body,long userId) {
        this.title = title;
        this.body = body;
        this.creator= new BlogUser();
        creator.setId(userId);

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

    public void addBlog(String newBlog) {
    }

}
