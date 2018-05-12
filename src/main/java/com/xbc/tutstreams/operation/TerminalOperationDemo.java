package com.xbc.tutstreams.operation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class TerminalOperationDemo {
  static Collection<String> arrayList = new ArrayList<>();

  public static void main(String[] args) {

    init();

    reduceElements();

    collectElements1();

    getMinMaxElement();

    getMatches();

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

  public static void reduceElements(){

    System.out.println("\n--- Reduce Elements to a formatted data ---");

    // Create a stream from the ArrayList
    Stream<String> stream = arrayList.stream();

    BinaryOperator<String> accumulator = (w1,w2) -> w1 +","+ w2 ;

    // reduce() requires a function of type BinaryOperator to format the data
    stream
        .reduce(accumulator)
        .ifPresentOrElse(
            System.out::println,
            ()-> System.out.println("Empty Stream")
        );
  }

  public static void collectElements1(){

    System.out.println("\n--- Reduce Elements to a formatted data using  Supplier, Accumulator and Combiner ---");

    // Create a stream from the ArrayList
    Stream<String> stream = arrayList.parallelStream();

    // supplier : It creates a new result container
    // which will be populated by accumulator and combiner
    Supplier<StringBuilder > supplier = StringBuilder::new ;

    // accumulator : It incorporates additional element into the result.
    BiConsumer<StringBuilder, String> accumulator =
        (res, word) ->  res.append(word.toUpperCase()).append(".");

    // combiner : It combines two values that must be compatible with accumulator.
    // Combiner works only in parallel processing.
    BiConsumer<StringBuilder, StringBuilder> combiner
        = (res1, res2) ->   res1.append("\n").append(res2).toString();

    // reduce() requires a function of type BinaryOperator to format the data
    String collectedStream = stream
        .collect(supplier, accumulator, combiner)
        .toString();
    System.out.println(collectedStream);
  }

  public static void getMinMaxElement(){
    Stream<String> stream ;
    System.out.println("\n--- The element with the MIN length ---");

    // Create a stream from the ArrayList
    stream = arrayList.parallelStream();

    stream
        .min(Comparator.comparing(String::length))
        .ifPresentOrElse(System.out::println, ()-> System.out.println("Empty :: No Min"));
    stream.close();


    System.out.println("\n--- The element with the MAX length ---");

    // Create a stream from the ArrayList
    stream = arrayList.parallelStream();

    stream
        .max(Comparator.comparing(String::length))
        .ifPresentOrElse(System.out::println, ()-> System.out.println("Empty :: No Max"));
    stream.close();
  }

  public static void getMatches(){

    Stream<String> stream ;

    System.out.println("\n--- All the elements contain the letter 'a' ? ---");

    // Create a stream from the ArrayList
    stream = arrayList.parallelStream();

    boolean allMatch = stream
        .allMatch(word -> word.contains("a"));
    stream.close();
    System.out.println(allMatch);


    System.out.println("\n--- There is at least one element with a length greater than 7 ---");

    stream = arrayList.parallelStream();
    boolean anyMatch = stream
        .anyMatch(word -> word.length()>7);
    stream.close();
    System.out.println(anyMatch);


    System.out.println("\n--- There is no element with a length less than 5 ---");

    stream = arrayList.parallelStream();
    boolean noneMatch = stream
        .noneMatch(word -> word.length()<5);
    stream.close();
    System.out.println(noneMatch);

  }

}