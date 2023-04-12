package degtyarev.kolya.later.user.repository;

import degtyarev.kolya.later.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryUserRepository implements UserRepository {
	private final Map<Long, User> users;
	private long idCounter;

	public InMemoryUserRepository() {
		users = new HashMap<>();
		idCounter = 0;
	}

	@Override
	public Optional<User> getUserById(long userId) {
		return Optional.ofNullable(users.get(userId));
	}

	@Override
	public List<User> getUsers() {
		return new ArrayList<>(users.values());
	}

	@Override
	public User saveUser(User user) {
		user.setId(++idCounter);
		users.put(user.getId(), user);
		return user;
	}

	@Override
	public Optional<User> deleteUserById(long userId) {
		Optional<User> user = Optional.ofNullable(users.get(userId));
		users.remove(userId);
		return user;
	}

	@Override
	public boolean contains(User user) {
		return users.containsValue(user);
	}
}
