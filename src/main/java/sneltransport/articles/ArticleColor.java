package sneltransport.articles;

import sneltransport.utils.PropertiesDynaEnum;

public class ArticleColor extends PropertiesDynaEnum {
	static {
		init(ArticleColor.class);
	}

	protected ArticleColor(String name, int ordinal) {
		super(name, ordinal);
	}

	
	/**
	 * Explicit definition of values() is needed here to trigger static initializer.
	 * @return
	 */
    public static ArticleColor[] values() {
    	return values(ArticleColor.class);
    }
	
}