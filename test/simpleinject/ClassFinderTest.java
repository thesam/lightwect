package simpleinject;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class ClassFinderTest {
	
	public class A {
		
	}
	@Test
	public void canFindClassesOnClasspath() throws Exception {
		ClassFinder finder = new ClassFinder();
		List<Class> find = finder.find();
		assertTrue(find.contains(A.class));
	}

}
