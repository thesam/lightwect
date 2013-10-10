package simpleinject;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class A {
	public B b;

	@Inject
	public A(B b) {
		this.b = b;
	}
}
