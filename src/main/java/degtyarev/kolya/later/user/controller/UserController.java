package degtyarev.kolya.later.user.controller;

import degtyarev.kolya.later.user.model.User;
import degtyarev.kolya.later.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {
	private UserService userService;

	@GetMapping("/{userId}")
	public User getUserById(@PathVariable long userId) {
		return userService.getUserById(userId);
	}

	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@PostMapping
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@DeleteMapping("/{userId}")
	public User deleteUser(@PathVariable long userId) {
		return userService.deleteUser(userId);
	}
}
