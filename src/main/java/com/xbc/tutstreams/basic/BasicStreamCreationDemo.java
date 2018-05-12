package com.xbc.tutstreams.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class BasicStreamCreationDemo {

  public static void main(String[] args) {

    Collection<String> arrayList = new ArrayList<>();
    arrayList.add("Word 1");
    arrayList.add("Word 2");
    arrayList.add("Word 3");

    System.out.println("*** Creation of Streams - Demonstration ***");

    System.out.println("\n--- Creating an Empty Stream ---");
    Stream<Object> emptyStream = Stream.empty();
    System.out.println("Number of available elements: " + emptyStream.count());

    System.out.println("\n--- Creating a Stream from the elements of a collection ---");
    Stream<String> streamFromCollection = arrayList.stream();
    System.out.println("Number of available elements: " + streamFromCollection.count());
    arrayList.stream().forEach(System.out::println);

    System.out.println("\n--- Creating a Stream from the arguments passed to the factory method ---");
    Stream<String> streamFromArguments = Stream.of("hello", "world", "stream", "api");
    System.out.println("Available elements: ");
    streamFromArguments.forEach(System.out::println);

    System.out.println("\n--- Creating a Stream from the elements of an array ---");
    Stream<String> streamFromArray = Stream.of(new String[] {"UK", "JP", "DZ"});
    System.out.println("Available elements: ");
    streamFromArray.forEach(System.out::println);

  }

}
