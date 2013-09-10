package simpleinject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class ClassFinder {

	public List<Class> findAll() throws Exception {
		String classpath = System.getProperty("java.class.path");
		List<Class> classes = new ArrayList<>();
		for (String classpathentry : classpath.split(";")) {
			classes.addAll(traverse(new File(classpathentry)));
		}
		return classes;
	}

	private List<Class> traverse(File classpathentry) throws Exception {
		List<Class> classes = new ArrayList<>();
		if (classpathentry.isDirectory()) {
			for (File file : classpathentry.listFiles()) {
				classes.addAll(traverse(file));
			}
		} else {
			Package[] packages = Package.getPackages();
			for (Package package1 : packages) {
				try {
					Class clazz = Class.forName(package1.getName()
							+ "."
							+ classpathentry.getName().replaceAll("\\.class",
									""));
					classes.add(clazz);
				} catch (Exception e) {
				}
			}
		}
		return classes;
	}

}
