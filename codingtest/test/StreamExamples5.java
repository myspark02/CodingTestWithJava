package codingtest.test;

import java.util.*;

public class StreamExamples5 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");
        
        list.stream().map(String::toLowerCase)
                    .map(String::toUpperCase)
                    .forEach(System.out::println);
                        
    }   
}
