package simpleinject;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class ClassFinderTest {
	@Test
	public void testName() throws Exception {
		ClassFinder finder = new ClassFinder();
		List<Class> find = finder.find();
		assertTrue(find.size() > 0);
	}

}
