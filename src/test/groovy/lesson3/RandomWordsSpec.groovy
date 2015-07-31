package lesson3

import java.nio.file.Path
import java.nio.file.Paths

import spock.lang.Specification

class RandomWordsSpec extends Specification {

	def "reads words from file to list"() {
		given: "A file containing words"
		Path path = Paths.get("words")
		when: "Initialising the RandomWords class"
		RandomWords randomWords = new RandomWords(path);
		then: "The words from the file are read into memory"
		randomWords.allWords().size() == 63254
	}
	
	def "Can get a list of randomized words"() {
		given: "A file containing words"
		Path path = Paths.get("words")
		when: "Creating a random list with three elements."
		RandomWords randomWordGenerator = new RandomWords(path);
		List<String> randomWords = randomWordGenerator.createList(3)
		then: "There should be three elements in the list."
		randomWords.size() == 3
		System.out.println(randomWords)
	}
}
