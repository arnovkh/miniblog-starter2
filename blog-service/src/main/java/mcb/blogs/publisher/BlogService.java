package mcb.blogs.publisher;

import mcb.blogs.publisher.restmodel.CreateBlogRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/blogs")
@CrossOrigin(origins = "*")
public class BlogService {
    private BlogRepository repository;

    @Autowired
    public BlogService(BlogRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity createBlog(@RequestBody CreateBlogRequest request) {

            BlogPost blog = new BlogPost(request.getTitle(), request.getBody(),request.getUserId());
            this.repository.save(blog);
            return ResponseEntity.created(URI.create("/blogs/"  )).build();

    }

    @RequestMapping(value = "/{id}/like/{plusminus}", method = POST)
    public ResponseEntity ModifyLike(@PathVariable Long id,@PathVariable int plusminus) {
        var blog = repository.findById(id).get();
        if(plusminus ==1 ) {
            blog.addLike();
        }
        else
        {
            blog.removeLike();
        }
        return ResponseEntity.ok(repository.save(blog));

    }
    @RequestMapping(value = "/{id}/reply", method = POST)
    public ResponseEntity addReply(@PathVariable Long id,@RequestBody CreateBlogRequest request) {

        var blog = repository.findById(id).get();
        blog.addReply(new BlogPost(request.getTitle(), request.getBody(), request.getUserId()));
        this.repository.save(blog);
        return ResponseEntity.created(URI.create("/blogs/" + id)).build();
    }



    @GetMapping
    public ResponseEntity getBlogs() {
        return ResponseEntity.ok(repository.findAll());

    }

}