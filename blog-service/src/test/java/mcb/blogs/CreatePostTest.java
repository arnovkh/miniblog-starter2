package mcb.blogs;

import mcb.blogs.publisher.BlogPost;
import mcb.blogs.publisher.BlogPostList;
import mcb.blogs.publisher.BlogService;
import mcb.blogs.publisher.restmodel.CreateBlogRequest;
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

    /**@Test
    public void shouldAbleToCreateNewBlogPost(){
      var blogPost = new CreateBlogRequest();
        var blogTitle = blogPost.setTitle("My blog Today");
        var blogBody = blogPost.setBody("CR7 is the best footballer in the world");
        var blogId = blogPost.setUserId(1);
        BlogService postBlog = new BlogPost(blogTitle, blogBody,blogId);
      assertThat(blogPost.getBody(), equalTo(initialBody));
      assertThat(blogPost.getTitle(), equalTo(newBlog));
    }**/

    @Test
     public void shouldBeAbleToLikePost(){
      var blogPost = new BlogPost("My blog Today","CR7 is the best footballer in the world", 1);
      var initialLike = blogPost.getLikes();
      blogPost.addLike();
      assertThat(blogPost.getLikes(), equalTo(initialLike +1));
    }

    @Test
    public void shouldBeAbleToReplyAPost(){
        var blogPost = new BlogPost("My blog Today","CR7 is the best footballer in the world", 1);
        var initialReply = blogPost.getReplies().size();

        blogPost.addReply(blogPost);
        assertThat(blogPost.getLikes(), equalTo(initialReply +1));
        //assertThat(blogPost.getReplies().get(initialReply).getTitle(), equalTo(blogPost));
    }
}
