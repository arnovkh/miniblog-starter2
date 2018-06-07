package mcb.blogs.publisher;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import mcb.blogs.users.BlogUser;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class BlogPost {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String body;

    private long likes;


//    private BlogPost parentPost;

    @OneToOne(cascade = CascadeType.MERGE , orphanRemoval = true, fetch = FetchType.EAGER)
    private BlogUser creator;

    protected BlogPost() {
        this.likes=0;
        replies = new ArrayList<>();
    }

    public BlogPost(String title, String body,long userId) {
        this.title = title;
        this.body = body;
        this.likes=0;
        this.creator= new BlogUser();
        replies = new ArrayList<>();
        creator.setId(userId);

}

    public Long getId() {
        return id;
    }


    public Long getLikes() {
        return likes;
    }


    public Long setLikes(Long likes) {
        return this.likes = likes;
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

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REMOVE,CascadeType.REFRESH}, orphanRemoval = true, fetch = FetchType.LAZY)
   // @JsonManagedReference
    List<BlogPost> replies ;

    public void setReplies(List<BlogPost> replies)
    {
        this.replies= replies;
    }

    public List<BlogPost> getReplies()
    {
       return replies;
    }

    public void addReply(BlogPost reply)
    {
        this.replies.add(reply);
    }

    public void addLike()
    {
        ++this.likes;
    }

    public void removeLike()
    {
        --this.likes;
    }

}
