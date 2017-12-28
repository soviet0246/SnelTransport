package sneltransport.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;

public class PropertiesDynaEnum extends DynaEnum<PropertiesDynaEnum> {
	
	protected PropertiesDynaEnum(String name, int ordinal) {
		super(name, ordinal);
	}

	public static <E> DynaEnum<? extends DynaEnum<?>>[] values() {
		return values(PropertiesDynaEnum.class);
	}

	protected static <E> void init(Class<E> clazz) {
		try {
			initProperties(clazz);
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	private static <E> void initProperties(Class<E> clazz) throws Exception {
		String rcName = clazz.getName().replace('.', '/') + ".properties";
		rcName = rcName.substring(rcName.lastIndexOf('/') + 1, rcName.length());
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(rcName)));

		Constructor<E> minimalConstructor = getConstructor(clazz, new Class[] { String.class, int.class });
		Constructor<E> additionalConstructor = getConstructor(clazz,
				new Class[] { String.class, int.class, String.class });
		int ordinal = 0;
		for (String line = reader.readLine(); line != null; line = reader.readLine()) {
			System.out.println("Properties DynaEnum 36 line: " + line);
			line = line.replaceFirst("#.*", "").trim();
			if (line.equals("")) {
				continue;
			}
			String[] parts = line.split("\\s*=\\s*");
			if (parts.length == 1 || additionalConstructor == null) {
				System.out.println("Properties DynaEnum 42 parts[0]: " + parts[0]);
				System.out.println("Properties DynaEnum 42 ordinal: " + ordinal);
				minimalConstructor.newInstance(parts[0], ordinal);
			} else {
				System.out.println("Properties DynaEnum 45");
				additionalConstructor.newInstance(parts[0], ordinal, parts[1]);
			}
			
		}
	}

	@SuppressWarnings("unchecked")
	private static <E> Constructor<E> getConstructor(Class<E> clazz, Class<?>[] argTypes) {
		for (Class<?> c = clazz; c != null; c = c.getSuperclass()) {
			try {
				return (Constructor<E>) c.getDeclaredConstructor(String.class, int.class, String.class);
			} catch (Exception e) {
				continue;
			}
		}
		return null;
	}
}
