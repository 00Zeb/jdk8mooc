import lesson1.Lesson1
import spock.lang.Specification

class Lesson1Spec extends Specification {

    def "exercise1"() {
        given: "A list with cool military words"
        def words = ["alpha", "bravo", "charlie", "delta", "echo", "foxtrot"]
        when: "sending the words through the exercise 1 function"
        def result = new Lesson1().exercise1(words);
        then: "A string where only the first letter in each word remains."
        result == "abcdef"
    }

    def "exercise2"() {
        given: "A list with cool military words"
        def words = ["alpha", "bravo", "charlie", "delta", "echo", "foxtrot"]
        when: "sending the words through the exercise 2 function"
        def result = new Lesson1().exercise2(words);
        then: "All words with odd lengths are removed from the original list."
        result == ["will use approval test here...."]
    }
}
