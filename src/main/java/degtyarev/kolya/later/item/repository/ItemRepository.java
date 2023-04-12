package degtyarev.kolya.later.item.repository;

import degtyarev.kolya.later.item.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
	Optional<Item> getItemById(long itemId);

	List<Item> getItems(long userId);

	Item saveItem(Item item);

	Optional<Item> deleteItemById(long itemId);

	boolean contains(Item item);
}
