package codingtest.test;

import java.util.Comparator;

public class LamdaExample {
    public static void main(String[] args) {
        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        };

        System.out.println(stringComparator.compare("Hello", "World"));

        Comparator<String> stringComparatorLamda = (String s1, String s2) -> {return s1.compareTo(s2);};

        System.out.println(stringComparatorLamda.compare("Hello", "World"));

        Comparator<String> stringComparatorLamda2 = (String s1, String s2) -> s1.compareTo(s2);

        System.out.println(stringComparatorLamda2.compare("Hello", "World"));

        // type inference
        Comparator<String> stringComparatorLamda3 = (s1, s2) -> s1.compareTo(s2);

        System.out.println(stringComparatorLamda3.compare("Hello", "World"));

        MyFunction myFunction = text -> {System.out.println("apply..." + text);};
        myFunction.apply("Hello World");

    }
    
}
