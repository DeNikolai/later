package degtyarev.kolya.later.item.repository;

import degtyarev.kolya.later.item.model.Item;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class InMemoryItemRepository implements ItemRepository {
	private final Map<Long, Item> items;
	private long idCounter;

	public InMemoryItemRepository() {
		items = new HashMap<>();
		idCounter = 0;
	}

	@Override
	public Optional<Item> getItemById(long itemId) {
		return Optional.ofNullable(items.get(itemId));
	}

	@Override
	public List<Item> getItems(long userId) {
		return items.values().stream()
				.filter(item -> item.getUserId().equals(userId))
				.collect(Collectors.toList());
	}

	@Override
	public Item saveItem(Item item) {
		item.setId(++idCounter);
		items.put(item.getId(), item);
		return item;
	}

	@Override
	public Optional<Item> deleteItemById(long itemId) {
		Optional<Item> item = Optional.ofNullable(items.get(itemId));
		items.remove(itemId);
		return item;
	}

	@Override
	public boolean contains(Item item) {
		return items.containsValue(item);
	}
}
