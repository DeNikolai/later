package degtyarev.kolya.later.item.controller;

import degtyarev.kolya.later.item.model.Item;
import degtyarev.kolya.later.item.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/items")
@AllArgsConstructor
public class ItemController {
	private ItemService itemService;

	@GetMapping
	public List<Item> get(@RequestHeader("X-Later-User-Id") long userId) {
		return itemService.getUserItems(userId);
	}

	@PostMapping
	public Item add(@RequestHeader("X-Later-User-Id") Long userId,
					@RequestBody Item item) {
		return itemService.addItem(userId, item);
	}

	@DeleteMapping("/{itemId}")
	public void deleteItem(@RequestHeader("X-Later-User-Id") long userId,
						   @PathVariable long itemId) {
		itemService.deleteItem(userId, itemId);
	}
}
