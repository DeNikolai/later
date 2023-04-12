package degtyarev.kolya.later.item.service;

import degtyarev.kolya.later.exception.ItemAlreadyExistException;
import degtyarev.kolya.later.exception.ItemDoesNotExistException;
import degtyarev.kolya.later.exception.NotOwnerException;
import degtyarev.kolya.later.exception.UserDoesNotExistException;
import degtyarev.kolya.later.item.model.Item;
import degtyarev.kolya.later.item.repository.ItemRepository;
import degtyarev.kolya.later.user.model.User;
import degtyarev.kolya.later.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {
	private ItemRepository itemRepository;
	private UserRepository userRepository;

	@Override
	public Item getUserIemById(long userId, long itemId) {
		isOwner(userId, itemId);
		return itemRepository.getItemById(itemId).orElseThrow(
				() -> new ItemDoesNotExistException("Item with id = " + itemId + " does not exist.")
		);
	}

	@Override
	public List<Item> getUserItems(long userId) {
		return itemRepository.getItems(userId);
	}

	@Override
	public Item addItem(long userId, Item item) {
		userRepository.getUserById(userId).orElseThrow(
				() -> new UserDoesNotExistException("User with id = " + userId + " does not exist.")
		);
		if (itemRepository.contains(item))
			throw new ItemAlreadyExistException(
					String.format("Item %s is already exist.", item)
			);
		item.setUserId(userId);
		return itemRepository.saveItem(item);
	}

	@Override
	public Item deleteItem(long userId, long itemId) {
		isOwner(userId, itemId);
		return itemRepository.deleteItemById(itemId).get();
	}

	private void isOwner(long userId, long itemId) {
		User user = this.userRepository.getUserById(userId).orElseThrow(
				() -> new UserDoesNotExistException("User with id = " + userId + " does not exist.")
		);
		Item item = itemRepository.getItemById(itemId).orElseThrow(
				() -> new ItemDoesNotExistException("Item with id = " + itemId + " does not exist.")
		);
		if (item.getUserId() != userId)
			throw new NotOwnerException(
					String.format("User with id = %s is not the owner of the item with id = %s",
							userId, itemId)
			);
	}
}
