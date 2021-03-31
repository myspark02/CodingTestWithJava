package codingwithscpark.collection;

import java.io.*;
import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("wordbook.txt")))) {
            String word = null;
            while((word = reader.readLine()) != null) {
                if (set.add(word) == false) {
                    System.out.printf("%s is already exist!\n", word);
                }
            }
            Iterator<String> iter = set.iterator();
            int cnt = 1;
            while(iter.hasNext()) {
                System.out.print(iter.next() + " ");
                if (cnt++ % 10 == 0) 
                    System.out.println();
            }
            System.out.printf("\nNumber of words is %d\n", set.size());
            

        }catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
