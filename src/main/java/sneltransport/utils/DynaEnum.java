package sneltransport.utils;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class DynaEnum<E extends DynaEnum<E>> {
	private static Map<Class<? extends DynaEnum<?>>, Map<String, DynaEnum<?>>> elements = new LinkedHashMap<Class<? extends DynaEnum<?>>, Map<String, DynaEnum<?>>>();

	private final String name;

	public final String name() {
		return name;
	}

	private final int ordinal;

	public final int ordinal() {
		return ordinal;
	}

	protected DynaEnum(String name, int ordinal) {
		this.name = name;
		this.ordinal = ordinal;
		Map<String, DynaEnum<?>> typeElements = elements.get(getClass());
		if (typeElements == null) {
			typeElements = new LinkedHashMap<String, DynaEnum<?>>();
			elements.put(getDynaEnumClass(), typeElements);
		}
		typeElements.put(name, this);
	}

	@SuppressWarnings("unchecked")
	private Class<? extends DynaEnum<?>> getDynaEnumClass() {
		return (Class<? extends DynaEnum<?>>) getClass();
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public final boolean equals(Object other) {
		return this == other;
	}

	@Override
	public final int hashCode() {
		return super.hashCode();
	}

	@Override
	protected final Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	public final int compareTo(E other) {
		DynaEnum<?> self = this;
		if (self.getClass() != other.getClass() && // optimization
				self.getDeclaringClass() != other.getDeclaringClass())
			throw new ClassCastException();
		return self.ordinal - other.ordinal();
	}

	@SuppressWarnings("unchecked")
	public final Class<E> getDeclaringClass() {
		Class clazz = getClass();
		Class zuper = clazz.getSuperclass();
		return (zuper == DynaEnum.class) ? clazz : zuper;
	}

	@SuppressWarnings("unchecked")
	public static <T extends DynaEnum<T>> T valueOf(Class<T> enumType, String name) {
		return (T) elements.get(enumType).get(name);
	}

	@SuppressWarnings("unused")
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		throw new InvalidObjectException("can't deserialize enum");
	}

	@SuppressWarnings("unused")
	private void readObjectNoData() throws ObjectStreamException {
		throw new InvalidObjectException("can't deserialize enum");
	}

	@Override
	protected final void finalize() {
	}

	public static <E> DynaEnum<? extends DynaEnum<?>>[] values() {
		throw new IllegalStateException("Sub class of DynaEnum must implement method valus()");
	}

	@SuppressWarnings("unchecked")
	public static <E> E[] values(Class<E> enumType) {
		Collection<DynaEnum<?>> values = elements.get(enumType).values();
		int n = values.size();
		E[] typedValues = (E[]) Array.newInstance(enumType, n);
		int i = 0;
		for (DynaEnum<?> value : values) {
			Array.set(typedValues, i, value);
			i++;
		}

		return typedValues;
	}
}
