package simpleinject;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

public class Injector {

	private Map<Class, Object> namedObjects = new HashMap<Class, Object>();
	private ClassFinder classFinder;

	public Injector(ClassFinder classFinder) {
		this.classFinder = classFinder;
	}

	public void injectAll() throws Exception {
		List<Class> namedClasses = classFinder.findWithClassAnnotation(Named.class);
		for (Class clazz : namedClasses) {
			for (Constructor constructor : clazz.getConstructors()) {
				if (constructor.getParameterTypes().length == 0) {
					Object newInstance = constructor.newInstance(null);
				} else {
					Object newInstance = constructor.newInstance(new B());
					namedObjects.put(clazz, newInstance);
				}
			}
		}
	}

	public <T> T getInstance(Class<T> clazz) {
		return (T) namedObjects.get(clazz);
	}

}
