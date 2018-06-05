package mcb.blogs;

import mcb.blogs.publisher.BlogPost;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CreatePostTest {

    @Test
     void shouldBeAbleToCreateNewPostOnBlog(){
     var blogPostList = new BlogPostList("New Blog Post List");
     var initialListBlog = blogPostList.getItems().size();
     String newPost = "My Post on CR7";
     blogPostList.addPost(newPost);
     assertThat(blogPostList.getItems().size(), equalTo(initialListBlog +1));
     assertThat(blogPostList.getItems().get(initialListBlog).getTitle(), equalTo(newPost));

    }

    @Test
    void shouldAbleToCreateNewBlogPost(){
      var blogPost = new BlogPost("My Post on CR7", "CR7 is a great footballer") ;
      var initialBlog = blogPost.getBody();
      String newBlog = "My Blog";
      blogPost.addBlog(newBlog);
      assertThat(blogPost.getTitle(), equalTo(initialBlog));
        //assertThat(blogPost.getTitle().ge(initialBlog).getTitle(), equalTo(newBlog));
    }
}
