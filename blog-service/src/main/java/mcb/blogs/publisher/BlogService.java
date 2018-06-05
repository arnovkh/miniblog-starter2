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
    public Mono<ResponseEntity> createBlog(@RequestBody Mono<CreateBlogRequest> request) {
        return request.map(r ->
        {
            BlogPost blog = new BlogPost(r.getTitle(), r.getBody(),r.getUserId());
            return this.repository.save(blog);
        })
                .map(BlogPost::getId).map(id -> ResponseEntity.created(URI.create("/blogs/" + id)).build());

    }

    @RequestMapping(value = "/{id}/{plusminus}", method = POST)
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
    @RequestMapping(value = "/{id}/rely", method = POST)
    public ResponseEntity addReply(@PathVariable Long id,@RequestBody Mono<CreateBlogRequest> request) {
        return request.map(r ->
        {
            var blog = repository.findById(id).get();
            blog.addReply(new BlogPost(r.getTitle(), r.getBody(), r.getUserId()));
            this.repository.save(blog);
            return ResponseEntity.created(URI.create("/blogs/" + id);
        });

    }



    @GetMapping
    public ResponseEntity getBlogs() {
        return ResponseEntity.ok(repository.findAll());

    }

}