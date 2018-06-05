package mcb.blogs.authentication;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<BlogUser, Long> {
}
