package lesson3

import spock.lang.Specification;

class LevenshteinSpec extends Specification {

	def "computes Levenshtein distance"(){
		given: "a list of words"
		List<String> words = ["abc", "abf"]
		when: "computing the levenstein"
		int[][] actual = Lesson3.computeLevenshtein(words, false)
		then: "the result should be"
		actual == [[0, 1], [1, 0]]
	}
}
