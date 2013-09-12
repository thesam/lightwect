package simpleinject;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ClassFinderTest {

	private ClassFinder finder;

	public class A {

	}

	public class B {
		@LightwectTestAnnotation
		public B() {

		}

	}

	@Before
	public void setUp() {
		finder = new ClassFinder();
	}

	@Test
	public void canFindClassesOnClasspath() throws Exception {
		List<Class> find = finder.findAll();
		assertTrue(find.contains(A.class));
		assertTrue(find.contains(B.class));
	}

	@Test
	public void canFindClassWithAnnotationOnConstructor() throws Exception {
		List<Class> find = finder
				.findWithConstructorAnnotation(LightwectTestAnnotation.class);
		assertTrue(find.contains(B.class));
		assertFalse(find.contains(A.class));
	}

}
