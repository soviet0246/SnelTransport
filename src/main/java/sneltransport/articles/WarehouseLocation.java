package sneltransport.articles;

import sneltransport.utils.PropertiesDynaEnum;

public class WarehouseLocation extends PropertiesDynaEnum {
	static {
		init(WarehouseLocation.class);
	}

	protected WarehouseLocation(String name, int ordinal) {
		super(name, ordinal);
	}

	/**
	 * Explicit definition of values() is needed here to trigger static initializer.
	 * 
	 * @return
	 */
	public static WarehouseLocation[] values() {
		return values(WarehouseLocation.class);
	}
}
