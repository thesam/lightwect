package simpleinject;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

public class InjectorTest {
	
	@Test
	public void testName() throws Exception {
		Injector injector = new Injector(new ClassFinder());
		injector.injectAll();
		A a = injector.getInstance(A.class);
		assertTrue(a.b instanceof B);
	}
}
