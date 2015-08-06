package testing

import spock.lang.Specification;

class ExampleSpec extends Specification {
	
	private static class Foo {
		Bar bar = new Bar();
		
		public List<String> getResult() {
			return bar.getResult();
		}
	}
	
	private static class Bar {
		
		public List<String> getResult() {
			throw new RuntimeException();
		}
	}

	def "my test"() {
		given: 
		Bar bar = Stub(Bar)
		Foo foo = new Foo();
		foo.bar = bar
		when:
		List<String> result = foo.getResult();
		then:
		result == []
	}
}
