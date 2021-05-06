package codingwithscpark;

import java.util.*;
import java.util.stream.IntStream;

public class SearchTest {
    public static void main(String[] args) {
        int key = 50;
        Random rand = new Random();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            // list.add(i);
            list.add(rand.nextInt(200));
        }
        Collections.sort(list);
        System.out.println(list);
        int index = Collections.binarySearch(list, key);
        System.out.println("탐색의 반환값 = " + index);
        
      
        // Collections.fill(list, 100);
        System.out.println("#################");
        // for (int val : list) System.out.println(val);

        List<Integer> list2 = new ArrayList<>(list.size()+1);
       
        Collections.copy(list2, list);
        // for (int val : list2) System.out.println(val);

        // Collections.swap(list, 0, 99);
        Collections.addAll(list2, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(list2);

        int n = Collections.frequency(list, 30);
        System.out.println(n);

        boolean flag = Collections.disjoint(list, list2);
        System.out.println(flag);

    }
}
