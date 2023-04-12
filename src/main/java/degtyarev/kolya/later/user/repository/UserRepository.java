package degtyarev.kolya.later.user.repository;

import degtyarev.kolya.later.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
	Optional<User> getUserById(long userId);

	List<User> getUsers();

	User saveUser(User user);

	Optional<User> deleteUserById(long userId);

	boolean contains(User user);
}
