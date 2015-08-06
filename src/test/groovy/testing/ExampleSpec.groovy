package testing

import spock.lang.Specification;

class ExampleSpec extends Specification {
	
	private final static class Foo {
		Bar bar = new Bar();
		
		public List<String> getResult() {
			return Bar.getResult();
		}
	}
	
	private static class Bar {
		
		public final static List<String> getResult() {
			throw new RuntimeException();
		}
	}

	def "my test"() {
		given: 
		Bar bar = GroovyStub(Bar)
		Bar.getResult() >> ["hej", "hopp"]
		Foo foo = new Foo();
		foo.bar = bar
		when:
		List<String> result = foo.getResult();
		then:
		result == ["hej", "hopp"]
	}
}
