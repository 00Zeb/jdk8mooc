/**
 * Copyright © 2014, Oracle and/or its affiliates. All rights reserved.
 *
 * JDK 8 MOOC Lesson 2 homework
 */
package lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Speakjava (simon.ritter@oracle.com)
 */
public class Lesson2 {
  private static final String WORD_REGEXP = "[- .:,]+";
  private final Console console;

  public Lesson2(Console console) {
	this.console = console;
}

/**
   * Run the exercises to ensure we got the right answers
   *
   * @throws java.io.IOException
   */
  public void runExercises() throws IOException {
    System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 2");
    System.out.println("Running exercise 1 solution...");
    exercise1(Arrays.asList(
	        "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG"));
    System.out.println("Running exercise 2 solution...");
    exercise2(Arrays.asList(
	        "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG"));
    System.out.println("Running exercise 3 solution...");
    exercise3(Arrays.asList(
	        "The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog"));
    System.out.println("Running exercise 4 solution...");
    exercise4();
    System.out.println("Running exercise 5 solution...");
    exercise5();
    System.out.println("Running exercise 6 solution...");
    exercise6();
    System.out.println("Running exercise 7 solution...");
    exercise7();
  }

  /**
   * Exercise 1
   *
   * Create a new list with all the strings from original list converted to 
   * lower case and print them out.
 * @param words TODO
   */
  public void exercise1(List<String> words) {
    words.replaceAll(String::toUpperCase);
    console.println(words);
  }

  /**
   * Exercise 2
   *
   * Modify exercise 1 so that the new list only contains strings that have an
   * odd length
 * @param words TODO
   */
  public void exercise2(List<String> words) {
    List<String> oddLengthWords = words.stream().filter(w -> w.length() % 2 != 0).collect(Collectors.toList());
    console.println(oddLengthWords);
  }

  /**
   * Exercise 3
   *
   * Join the second, third and forth strings of the list into a single string,
   * where each word is separated by a hyphen (-). Print the resulting string.
 * @param words TODO
   */
  public void exercise3(List<String> words) {
    List<String> list = words;
    String secretWord = words.stream().skip(1).limit(3).collect(Collectors.joining("-"));
	console.println(secretWord);
  }

  /**
   * Count the number of lines in the file using the BufferedReader provided
   */
  public void exercise4() throws IOException {
    try (BufferedReader reader = Files.newBufferedReader(
        Paths.get("SonnetI.txt"), StandardCharsets.UTF_8)) {
    	console.println(reader.lines().count());
    }
  }
  
  /**
   * Using the BufferedReader to access the file, create a list of words with
   * no duplicates contained in the file.  Print the words.
   * 
   * HINT: A regular expression, WORD_REGEXP, is already defined for your use.
   */
  private void exercise5() throws IOException {
    try (BufferedReader reader = Files.newBufferedReader(
        Paths.get("SonnetI.txt"), StandardCharsets.UTF_8)) {
      /* YOUR CODE HERE */
    }
  }
  
  /**
   * Using the BufferedReader to access the file create a list of words from 
   * the file, converted to lower-case and with duplicates removed, which is
   * sorted by natural order.  Print the contents of the list.
   */
  private void exercise6() throws IOException {
    try (BufferedReader reader = Files.newBufferedReader(
        Paths.get("SonnetI.txt"), StandardCharsets.UTF_8)) {
      /* YOUR CODE HERE */
    }
  }
  
  /**
   * Modify exercise6 so that the words are sorted by length
   */
  private void exercise7() throws IOException {
    try (BufferedReader reader = Files.newBufferedReader(
        Paths.get("SonnetI.txt"), StandardCharsets.UTF_8)) {
      /* YOUR CODE HERE */
    }
  }

  /**
   * Main entry point for application
   *
   * @param args the command line arguments
   * @throws IOException If file access does not work
   */
  public static void main(String[] args) throws IOException {
    Lesson2 lesson = new Lesson2(new Console());
    lesson.runExercises();
  }
}

