package codingwithscpark.collection;

import java.util.*;

public class Sort {
    public static void main(String[] args) {
        // String[] sample = {"i", "walk", "the", "line"};
        // selectionSort(sample);
        // print(sample);

        // List<String> list = Arrays.asList(sample);
        // System.out.println(list);

        int key = 49; 
        Integer[] arr = new Integer[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i*2;
        }

        print(arr);
        int index = binarySearch(arr, key);

        System.out.println("탐색의 반환값 = " + index);
    }

    public static <T extends Comparable<T>> void selectionSort(T[] arr ) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[min].compareTo(arr[j]) > 0) {
                    min = j;
                }
            }
            T tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;

        }
    }

    public static void print(Object[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + ", ");
        }
        if (arr.length > 0) System.out.print(arr[arr.length-1]);
        System.out.println("]\n");
    }

    public static <T extends Comparable<T>>int binarySearch(T[] arr, T key) {
       
        int left = 0; 
        int right = arr.length - 1;
        
        while (right >= left) {
            int mid = (left+right)/2;
            if (arr[mid].compareTo(key) == 0) return mid;
            if (arr[mid].compareTo(key) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1*left;

    }
}
