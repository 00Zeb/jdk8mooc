/**
 * Copyright © 2014, Oracle and/or its affiliates. All rights reserved.
 * <p>
 * JDK 8 MOOC Lesson 1 homework
 */
package lesson1;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.stream.Collectors.joining;

/**
 * @author Speakjava (simon.ritter@oracle.com)
 */
public class Lesson1 {
    private final ExecutorService es;

    public Lesson1(ExecutorService es) {
		this.es = es;
	}
    
	/**
     * Run the exercises to ensure we got the right answers
     */
    public void runExercises() {
        System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 1");
        System.out.println("Running exercise 1 solution...");
        exercise1(Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));
        System.out.println("Running exercise 2 solution...");
        exercise2(new ArrayList<>(Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot")));
        System.out.println("Running exercise 3 solution...");
        exercise3(new ArrayList<>(Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot")));
        System.out.println("Running exercise 4 solution...");
        Map<String, Integer> map = new TreeMap<>();
        map.put("c", 3);
        map.put("b", 2);
        map.put("a", 1);
        exercise4(map);
        System.out.println("Running exercise 5 solution...");
        exercise5(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    /**
     * All exercises should be completed using Lambda expressions and the new
     * methods added to JDK 8 where appropriate. There is no need to use an
     * explicit loop in any of the code. Use method references rather than full
     * lambda expressions wherever possible.
     */
    /**
     * Exercise 1
     *
     * Create a string that consists of the first letter of each word in the
     * list of Strings provided.
     * @param strings
     */
    public String exercise1(List<String> words) {
        StringBuilder sb = new StringBuilder();
        words.forEach(element -> sb.append(element.charAt(0)));
        return sb.toString();
    }

    /**
     * Exercise 2
     *
     * Remove the words that have odd lengths from the list.
     * @param words
     */
    public void exercise2(List<String> words) {
        words.removeIf(each -> each.length() % 2 != 0);
    }

    /**
     * Exercise 3
     *
     * Replace every word in the list with its upper case equivalent.
     * @param words
     */
    public void exercise3(List<String> words) {
        words.replaceAll(String::toUpperCase);
    }

    /**
     * Exercise 4
     *
     * Convert every key-value pair of the map into a string and append them all
     * into a single string, in iteration order.
     * @param map
     */
    public String exercise4(Map<String, Integer> map) {
        return map.entrySet().stream()
                .map(e -> e.getKey() + e.getValue())
                .collect(joining()).toString();
    }

    /**
     * Exercise 5
     *
     * Create a new thread that prints the numbers from the list.
     * @param numbers
     */
    public void exercise5(List<Integer> numbers) {
        es.execute(() -> numbers.forEach(n -> System.out.println(n)));
    }

    /**
     * Main entry point for application
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        Lesson1 lesson = new Lesson1(Executors.newCachedThreadPool());
        lesson.runExercises();
    }
}
