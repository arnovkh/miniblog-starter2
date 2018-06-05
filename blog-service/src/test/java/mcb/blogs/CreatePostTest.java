package mcb.blogs;

import mcb.blogs.publisher.BlogPost;
import mcb.blogs.publisher.BlogPostList;
import org.junit.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CreatePostTest {

    @Test
    public void shouldBeAbleToCreateNewPostOnBlog(){
     var blogPostList = new BlogPostList("New Blog Post List");
     var initialListBlog = blogPostList.getItems().size();
     String newPost = "My Post on CR7";
     blogPostList.addPost(newPost);
     assertThat(blogPostList.getItems().size(), equalTo(initialListBlog +1));
     assertThat(blogPostList.getItems().get(initialListBlog).getTitle(), equalTo(newPost));
    }

    @Test
    public void shouldAbleToCreateNewBlogPost(){
      var blogPost = new BlogPost("My Post on CR7", "CR7 is a great footballer",0) ;
      //var initialTitle = blogPost.getTitle();
      var initialBody = blogPost.getBody();
      String newBlog = "My Post on CR7";
      blogPost.addBlog(newBlog);
      assertThat(blogPost.getBody(), equalTo(initialBody));
      assertThat(blogPost.getTitle(), equalTo(newBlog));
    }

    @Test
     public void shouldBeAbletoLIkePost(){

    }
}
