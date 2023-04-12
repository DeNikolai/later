package degtyarev.kolya.later.user.service;

import degtyarev.kolya.later.user.model.User;

import java.util.List;

public interface UserService {
	User getUserById(long userId);

	List<User> getUsers();

	User addUser(User user);

	User deleteUser(long userId);
}
