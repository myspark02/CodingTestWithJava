package codingtest.test.set;

import java.util.*;

public class SetExamples {
    public static void main(String[] args) {
        // Set set = new HashSet();    

        // Set set2 = new TreeSet();

        Set<String> set = new HashSet<>();
        
        boolean added = set.add("Hello");
        boolean added2 = set.add("Hello");
        System.out.println(added + ", " + added2);

        Set<String> set2 = Set.of("Hello", "World", "1", "2", "3");

        Iterator<String> iterator = set2.iterator();
        while(iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
        System.out.println("\n####################");
        Set<String> set3 = new TreeSet<>();
        set3.add("Hello");
        set3.add("World");
        set3.add("1");
        set3.add("2");
        set3.add("3");

        iterator = set3.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    
        System.out.println("\n####################");

        for (String element: set3)
            System.out.println(element);

        System.out.println("\n####################");     

        set3.stream().forEach(System.out::println);

        // boolean removed = set3.remove("1");
        // System.out.println(removed);

        // set3.addAll(Set.of("1", "9", "abc"));
        // System.out.println(set3);

        // set.clear();
        // System.out.println(set);

        // set3.removeAll(Set.of("1", "9", "abc"));

        System.out.println(set3.size());
        set3.retainAll(Set.of("1", "9", "abc"));
        System.out.println(set3);
        System.out.println(set3.isEmpty());
        System.out.println(set3.contains("9"));

        List<String> list = new ArrayList<>();
        list.addAll(set2);
        System.out.println(list);
    }
}
