package degtyarev.kolya.later.user.service;

import degtyarev.kolya.later.exception.UserAlreadyExistException;
import degtyarev.kolya.later.exception.UserDoesNotExistException;
import degtyarev.kolya.later.user.model.User;
import degtyarev.kolya.later.user.repository.UserRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;

	@Override
	public User getUserById(long userId) {
		return userRepository.getUserById(userId).orElseThrow(
				() -> new UserDoesNotExistException("User with id = " + userId + " does not exist.")
		);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.getUsers();
	}

	@Override
	public User addUser(User user) {
		if (userRepository.contains(user))
			throw new UserAlreadyExistException(user + " already exist.");
		return userRepository.saveUser(user);
	}

	@Override
	public User deleteUser(long userId) {
		return userRepository.deleteUserById(userId).orElseThrow(
				() -> new UserDoesNotExistException("User with id = " + userId + " does not exist.")
		);
	}
}
