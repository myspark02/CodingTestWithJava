package codingtest.test.iterable;

import java.util.*;

public class IterableExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // Set<String> list = new HashSet<>();

        list.add("one");
        list.add("two");
        list.add("three");

        System.out.println("\n###################");
        for (String elem: list) {
            System.out.println(elem);
        }


        System.out.println("\n###################");
        Collection<String> collection = list;
        Iterable<String> iterable = collection;

        for(String elem : iterable) {
            System.out.println(elem);
        }

        System.out.println("\n###################");
        Iterator<String> iterator = iterable.iterator();
        while(iterator.hasNext()) {
            String elem = iterator.next();
            System.out.println(elem);
        }

        
        System.out.println("\n###################");
        iterable.forEach(System.out::println);

        System.out.println("\n###################");
        Spliterator<String> spliterator = iterable.spliterator();
        
    
    }



}
