import lesson1.Lesson1
import org.hamcrest.BaseMatcher
import org.hamcrest.Description
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

    def "exercise5"() {
        given: "Some numbers and control of System Out."
        ByteArrayOutputStream outputBytes = new ByteArrayOutputStream();
        def originalOut = System.out
        System.setOut(new PrintStream(outputBytes))
        List<Integer> numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        when: "exercise5 is called"
        new Lesson1().exercise5(numbers);
        then: "All numbers have been printed to system out"
        //TODO: find better assertion that gives a nice Groovy assert clue.
        outputBytes.toString().findAll("1-9]|10")
        //outputBytes.toString() matches("1-9]|10")
        //numbers.every {e -> outputBytes.toString().find(String.valueOf(e))}
        cleanup: "resets system out"
        System.setOut(originalOut)
    }


    private static class RegexMatcher extends BaseMatcher{
        private final String regex;

        public RegexMatcher(String regex){
            this.regex = regex;
        }

        public boolean matches(Object o){
            return ((String)o).matches(regex);
        }

        public void describeTo(Description description){
            description.appendText("matches regex=");
        }

        public static RegexMatcher matches(String regex){
            return new RegexMatcher(regex);
        }
    }
}
