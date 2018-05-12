package com.xbc.tutstreams.operation;

import java.awt.SystemTray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class BasicStreamOperationDemo {

  static Collection<String> arrayList = new ArrayList<>();

  public static void main(String[] args) {

    init();

    printAllStreamElements();

    removeDuplicatesFromStream();

    extractLimitedElements();

    skipSomeElements();

    sortElements();

    sortElementsByComparator();

    selectBasedOnCondition();

    transformStream();

    // Requires Java 9
    selectElemetsUntilConditionReturnTrue();

    // Requires Java 9
    skipElemetsUntilConditionReturnTrue();

  }

  public static void init(){
    arrayList.add("java");
    arrayList.add("stream");
    arrayList.add("java");
    arrayList.add("lambda");
    arrayList.add("function");
    arrayList.add("operation");
    arrayList.add("lambda");
    arrayList.add("other");
  }

  public static void printAllStreamElements(){
    System.out.println("\n--- Printing all elements of a stream. ---");

    // Create a stream from the ArrayList
    Stream<String> stream = arrayList.stream();

    System.out.println("Elements of the stream: ");
    stream.forEach(System.out::println);

  }

  public static void removeDuplicatesFromStream(){
    System.out.println("\n--- Removing duplicate elements from a stream. ---");

    // Create a stream from the ArrayList
    Stream<String> stream = arrayList.stream();

    System.out.println("Elements of the stream with single iteration for each element: ");
    stream
        .distinct()
        .forEach(System.out::println);
  }

  public static void extractLimitedElements(){
    System.out.println("\n--- Truncating a stream at a specific size. ---");

    // Create a stream from the ArrayList
    Stream<String> stream = arrayList.stream();

    System.out.println("Limited number of Elements from a stream: ");
    stream
        .limit(3)
        .forEach(System.out::println);
  }

  public static void skipSomeElements(){
    System.out.println("\n--- Discard some elements from the stream. ---");

    // Create a stream from the ArrayList
    Stream<String> stream = arrayList.stream();

    System.out.println("Rest of stream elements after skipping some: ");
    stream
        .skip(6)
        .forEach(System.out::println);
  }

  public static void sortElements(){
    System.out.println("\n--- Basic sorting of stream elements. ---");

    // Create a stream from the ArrayList
    Stream<String> stream = arrayList.stream();

    System.out.println("Sorted Elements: ");
    stream
        //.distinct()
        .sorted()
        .forEach(System.out::println);
  }

  public static void sortElementsByComparator(){
    System.out.println("\n--- sorting of stream elements based on Comparator. ---");

    // Create a stream from the ArrayList
    Stream<String> stream = arrayList.stream();

    System.out.println("Sorted Elements based on the length of each word: ");
    stream
        //.distinct()
        .sorted(Comparator.comparing(String::length))
        .forEach(System.out::println);
  }

  public static void selectBasedOnCondition(){
    System.out.println("\n--- Selecting elements matching a criterion. ---");

    // Create a stream from the ArrayList
    Stream<String> stream = arrayList.stream();
    // Define the condition to filter elements
    // select words that contain the letter 'a' once or more
    Predicate<String> condition = word -> word.contains("a");

    System.out.println("Filtered words from the Stream based on the given condition: ");
    stream
        //.distinct()
        .filter(condition)
        .forEach(System.out::println);
  }

  public static void transformStream(){
    System.out.println("\n--- Transform a stream into another stream. ---");

    // Create a stream from the ArrayList
    Stream<String> stream = arrayList.stream();

    // Define the function of transformation
    Function<String, Character> transform = word -> word.charAt(0);

    System.out.println("First Caracter of each element of the stream: ");

    stream
        //.distinct()
        .map(transform)
        //.distinct()
        .forEach(System.out::println);
  }

  public static void selectElemetsUntilConditionReturnTrue(){
    System.out.println("\n--- Select the first elements before the Condition return true. ---");

    // Create a stream from the ArrayList
    Stream<String> stream = arrayList.stream();

    // Define the condition of type Predicate<T>
    Predicate<String> condition = word -> word.length() <= 6 ;

    stream
        //.sorted(Comparator.comparing(String::length))
        .takeWhile(condition)
        .forEach(System.out::println);
  }

  public static void skipElemetsUntilConditionReturnTrue() {
    System.out.println("\n--- Select elements after the Condition return true. ---");

    // Create a stream from the ArrayList
    Stream<String> stream = arrayList.stream();

    // Define the condition of type Predicate<T>
    Predicate<String> condition = word -> !word.equals("operation") ;

    stream
        .dropWhile(condition)
        .forEach(System.out::println);

  }
}