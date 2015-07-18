import lesson1.Lesson1
import spock.lang.Specification


class WordManipulationSpec extends Specification {
    List<String> words
    Lesson1 lesson1

    def setup() {
        words = ["alpha", "bravo", "charlie", "delta", "echo", "foxtrot"]
        lesson1 = new Lesson1()
    }

    def "exercise1"() {
        when: "sending the words through the exercise 1 function"
        def result = lesson1.exercise1(words);
        then: "A string where only the first letter in each word remains."
        result == "abcdef"
    }

    def "exercise2"() {
        when: "sending the words through the exercise 2 function"
        lesson1.exercise2(words);
        then: "All words with odd lengths are removed from the original list."
        words == ["echo"]
    }

    def "exercise3"() {
        when: "sending the words through the exercise 3 function"
        lesson1.exercise3(words);
        then: "All words are upper cased."
        words == ["ALPHA", "BRAVO", "CHARLIE", "DELTA", "ECHO", "FOXTROT"]
    }
}

class Lesson1Spec extends Specification {

    def "exercise4"() {
        given: "A sorted map with some values"
        Map<String, Integer> map = new TreeMap<>();
        map.put("c", 3);
        map.put("b", 2);
        map.put("a", 1);
        when: "exercise4 is called"
        def result = new Lesson1().exercise4(map);
        then: "Every key-value pair of the map is converted into a single string, in iteration (sorted) order."
        result == "a1b2c3"
    }
}
