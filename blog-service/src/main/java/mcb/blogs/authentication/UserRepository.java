package mcb.blogs.authentication;

import mcb.blogs.publisher.UserList;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<BlogUser, Long> {
}
