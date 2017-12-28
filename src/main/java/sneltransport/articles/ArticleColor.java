package sneltransport.articles;

<<<<<<< HEAD
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
=======
public enum ArticleColor {
	ZWART,
	ZILVER,
	WIT,
	GRIJS,
	GEEN
}
>>>>>>> parent of 4fbf63c... Correctie, had nog niet alle bestanden gecorrigeerd.
