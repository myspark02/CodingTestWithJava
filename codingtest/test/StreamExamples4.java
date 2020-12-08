package codingtest.test;

import java.util.*;
import java.util.stream.*;

public class StreamExamples4 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");
        
        list.stream().map(elem->{
                        return elem.toLowerCase();
                    })
                    .map(elem->{
                        return elem.toUpperCase();
                    })
                    .forEach(elem->{
                        System.out.println(elem);
                    });
    }
      
    
}
