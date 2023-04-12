package degtyarev.kolya.later.item.service;

import degtyarev.kolya.later.item.model.Item;

import java.util.List;

public interface ItemService {
	Item getUserIemById(long userId, long itemId);

	List<Item> getUserItems(long userId);

	Item addItem(long userId, Item item);

	Item deleteItem(long userId, long itemId);
}
