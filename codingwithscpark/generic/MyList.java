package codingwithscpark.generic;

import java.util.*;

public class MyList {
    public static void printListW(List<?> list) {
        for (Object o : list) System.out.println(o);
    }

    public static <T> void printListG(List<T> list) {
        list.forEach(e -> System.out.println(e));
    }

    // public static void printList(List<? super Integer> list) {

    // }

    // public static void printList(List<? super Number> list) {

    // }

    // public static void printList(List<Number> list) {

    // }

    public static void test(Object o) {

    }

    public static void test(String s) {

    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<String> list2 = Arrays.asList("one", "two", "three");

        MyList.printListW(list1);
        System.out.println("\n################\n");
        MyList.printListW(list2);
    }
    
}
