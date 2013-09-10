package simpleinject;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassFinder {

	public List<Class> find() {
		String classpath = System.getProperty("java.class.path");
		for (String classpathentry : classpath.split(";")) {
			File dir = new File(classpathentry);
			if (dir.isDirectory()) {
				for (File file : dir.listFiles()) {
					System.out.println(file);
				}
			}
		}
		return new ArrayList<>();
	}

}
