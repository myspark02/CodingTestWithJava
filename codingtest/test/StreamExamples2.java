package codingtest.test;

import java.util.*;
import java.util.stream.*;

public class StreamExamples2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");

        Stream<String> stream = list.stream();

        Stream<String> lowercaseStream = stream.map((elem->{return elem.toLowerCase();}));

        lowercaseStream.forEach(elem->{System.out.println(elem);});
        
        
    }
    
}
