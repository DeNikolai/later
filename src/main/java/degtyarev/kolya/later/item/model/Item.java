package degtyarev.kolya.later.item.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
public class Item {
	@EqualsAndHashCode.Exclude
	private Long id;
	private Long userId;
	private String url;
}
