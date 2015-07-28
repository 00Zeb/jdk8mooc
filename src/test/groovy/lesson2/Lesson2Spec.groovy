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
		when: "Parsing the file contents"
		new Lesson2(console).exercise5()
		then: "All words that occur only once in the file are printed to the console."
		1 * console.println(['From', 'fairest', 'creatures', 'we', 'desire', 'increase', 'That', 'thereby', 'beauty\'s', 'rose', 'never', 'die', 'as', 'riper', 'should', 'time', 'decease', 'His', 'heir', 'bear', 'his', 'memory', 'thou', 'contracted', 'bright', 'eyes', 'Feed\'st', 'light\'s', 'flame', 'with', 'substantial', 'fuel', 'Making', 'a', 'famine', 'where', 'abundance', 'lies', 'Thy', 'foe', 'sweet', 'too', 'cruel', 'Thou', 'that', 'art', 'now', 'fresh', 'ornament', 'only', 'herald', 'gaudy', 'spring', 'Within', 'bud', 'buriest', 'content', 'churl', 'mak\'st', 'waste', 'in', 'niggarding', 'Pity', 'world', 'or', 'else', 'this', 'glutton', 'be', 'To', 'eat', 'due', 'grave', 'and', 'thee'])
	}

	def "exercise 6"() {
		given: "A console"
		Console console = Mock()
		when: "Parsing the file contents"
		new Lesson2(console).exercise6()
		then: "All words in the file are printed to the console in lowercase and only once, sorted in natural order."
		1 * console.println(['a', 'abundance', 'and', 'and', 'art', 'as', 'be', 'bear', 'beauty\'s', 'bright', 'bud', 'buriest', 'but', 'by', 'churl', 'content', 'contracted', 'creatures', 'cruel', 'decease', 'desire', 'die', 'due', 'eat', 'else', 'eyes', 'fairest', 'famine', 'feed\'st', 'flame', 'foe', 'fresh', 'from', 'fuel', 'gaudy', 'glutton', 'grave', 'heir', 'herald', 'his', 'his', 'in', 'increase', 'lies', 'light\'s', 'mak\'st', 'making', 'memory', 'might', 'never', 'niggarding', 'now', 'only', 'or', 'ornament', 'own', 'pity', 'riper', 'rose', 'self', 'should', 'spring', 'substantial', 'sweet', 'tender', 'that', 'that', 'the', 'thee', 'thereby', 'thine', 'this', 'thou', 'thou', 'thy', 'thy', 'time', 'to', 'to', 'too', 'waste', 'we', 'where', 'with', 'within', 'world', 'world\'s'])
	}

	def "exercise 7"() {
		given: "A console"
		Console console = Mock()
		when: "Parsing the file contents"
		new Lesson2(console).exercise7()
		then: "All words in the file are printed to the console in lowercase and only once, but sorted in length of the strings."
		1 * console.println("something")
	}


}
