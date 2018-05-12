package com.xbc.tutstreams.creation;

import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AdvancedStreamCreationDemo {

  public static void main(String[] args) {

    System.out.println("*** Creation of Streams - Demonstration ***");

    createInfiniteStream();

    createLimitedSequence();

    createStreamFromGenerator();

    createStreamFromRange();
  }

  public static void createInfiniteStream() {
    System.out.println(
        "\n--- Create an infinite stream consisting of the sequence u0, u1, .. un ---");

    // Define the starting point (First memeber/term) and the Pattern
    int u0 = 0;
    // UnaryOperator is a type of java.util.Function
    // where both return value and parameter have the same data type
    UnaryOperator<Integer> pattern = un -> 2 * un + 1;

    // Stream.iterate requires a starting points u0,
    // and function of type UnaryOperator to create the next elements
    Stream<Integer> infiniteStream = Stream.iterate(u0, pattern);

    // Extracting a new limited stream from the infinite stream
    Stream<Integer> limitedStream = infiniteStream.limit(10);

    System.out.println("Available first 10 elements: ");
    limitedStream.forEach(System.out::println);
  }

  public static void createLimitedSequence() {
    System.out.println(
        "\n--- Create a limited sequence u0, u1, .. uk "
            + "\n    k is the first index where the condition return true ---");

    // Define the starting point and the incrementation criteria
    int u0 = 0;
    // UnaryOperator is a type of java.util.Function
    // where both return value and parameter have the same data type
    UnaryOperator<Integer> pattern = un -> 2 * un + 1;

    // Define the condition where the stream stops on the first match
    Predicate<Integer> condition = ui -> ui <= 2000;

    // Stream.iterate requires a starting points u0,
    // a condition where the stream stops on the first match
    // and a function of type UnaryOperator to create the next elements
    Stream<Integer> limitedSequence = Stream.iterate(u0, condition, pattern);

    System.out.println("Available elements: ");
    limitedSequence.forEach(System.out::println);
  }

  public static void createStreamFromGenerator() {
    System.out.println(
        "\n--- Create an infinite stream from a generator function ---");

    // Create an object of SequenceSupplier which implements Supplier interface
    SequenceSupplier pattern = new SequenceSupplier();

    // Stream.generate requires a pattern of type "Supplier" to create the infinite sequence
    Stream<Integer> streamFromGenerator = Stream.generate(pattern);

    // Extracting a new limited stream from the infinite stream
    Stream<Integer> limitedStream = streamFromGenerator.limit(10);

    System.out.println("Available first 10 elements: ");
    limitedStream.forEach(System.out::println);
  }

  public static void createStreamFromRange(){

    System.out.println(
        "\n--- Create a stream of Integers consisting of the elements"
            + " from lower to upper, exclusive. ---");

    IntStream openRangeIntStream = IntStream.range(0,10);
    openRangeIntStream.forEach(System.out::println);

    System.out.println(
        "\n--- Create a stream of Integers consisting of the elements"
            + " from lower to upper, exclusive. ---");

    IntStream closedRangeIntStream = IntStream.rangeClosed(0,10);
    closedRangeIntStream.forEach(System.out::println);

  }
}