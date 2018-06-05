package mcb.blogs.publisher;

import org.springframework.data.repository.CrudRepository;

public interface BlogRepository  extends CrudRepository<BlogPost, Long> {
}
