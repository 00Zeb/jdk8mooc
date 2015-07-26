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
	
	def "exercise 3"() {
		given: "A list of words."
		List<String> words = ["The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog"];
		and: "A console."
		Console console = Mock()
		when: "when joining parts into a secret string."
		new Lesson2(console).exercise3(words)
		then: "The secret string is printed to the console"
		1 * console.println("quick-brown-fox")
	}
	
	def "exercise 4"() {
		given: "A console"
		Console console = Mock()
		when: "counting the number of lines in a file."
		new Lesson2(console).exercise4()
		then: "The correct number of lines is printed to the console."
		1 * console.println(14)
	}
	
	def "exercise 5"() {
		given: "A console"
		Console console = Mock()
		when: "Getting removing duplicate strings from the file"
		new Lesson2(console).exercise5()
		then: "All distinct words are printed to the console"
		1 * console.println("some words")
	}
}
