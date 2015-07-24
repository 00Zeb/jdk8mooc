package lesson2

import spock.lang.Specification;

class Lesson2Spec extends Specification {

	def "exercise 1"() {
		given: "A console and a list that contains words with a mix of upper case and lower case characters."
		Console console = Mock()
		List<String> words = [
			"The",
			"Quick",
			"BROWN",
			"Fox",
			"Jumped",
			"Over",
			"The",
			"LAZY",
			"DOG"
		]
		when: "converting the words to uppercase"
		new Lesson2(console).exercise1(words);
		then: "The console should print all words in uppercase"
		1 * console.println([
			'THE',
			'QUICK',
			'BROWN',
			'FOX',
			'JUMPED',
			'OVER',
			'THE',
			'LAZY',
			'DOG'
		])
	}

	def "exercise 2"() {
		given: "A console and a list that contains words with mixed lengths."
		Console console = Mock()
		List<String> words = [
			"The",
			"Quick",
			"BROWN",
			"Fox",
			"Jumped",
			"Over",
			"The",
			"LAZY",
			"DOG"
		]
		when: "filtering out strings with even length"
		new Lesson2(console).exercise2(words);
		then: "The console should print all words with odd length"
		1 * console.println([
			'The', 'Quick', 'BROWN', 'Fox', 'The', 'DOG'
		])
	}
}
