package codingwithscpark.collection;

import java.util.*;
import java.util.Map.Entry;

public class MapTest {
    public static void main(String[] args) {
        // Map<String, Integer> map = new HashMap<>();
        // String[] sample = {"to", "be", "or", "not", "to", "be", "is", "a", "problem"};

        // for (String a : sample) {
        //     Integer freq = map.get(a);
        //     map.put(a, (freq==null)?1:freq+1);
        // }

        // System.out.println(map.size() + "개의 단어가 있습니다.");
        // System.out.println("to exist? :" + map.containsKey("to"));
        // System.out.println("is empty?:" + map.isEmpty());
        // System.out.println(map);
        test();
        // test2();
    }

    private static void test2() {
        Map<String, Student> map = new HashMap<String, Student>();
        map.put("30090001", new Student(2009005, "일지매"));
        map.put("20090005", new Student(2009005, "일지매"));
        map.put("10090006", new Student(2009006, "성춘향"));
        map.put("20090001", new Student(2009001, "구준표"));
        map.put("20090002", new Student(2009002, "금잔디"));
        map.put("20090003", new Student(2009003, "윤지후"));
        map.put("20090004", new Student(2009004, "홍길동"));
        
        Student student = new Student(2009007, "향단이");
        map.put("20090007", student);
        map.put("20090007", student);

        System.out.println(map);

        map.remove("20090002");

        map.put("20090003", new Student(20090003, "소이정"));

        System.out.println(map.get("20090003"));

        for (Map.Entry<String, Student> std : map.entrySet()) {
            String key = std.getKey();
            Student value = std.getValue();

            System.out.println("key=" + key + ", value=" + value);
        }

        System.out.println("################################");
        Set<String> keys = map.keySet();
        for (String key : keys) {
            Student value = map.get(key);

            System.out.println("key=" + key + ", value=" + value);
        }

    }

    private static void test() {
        String sample = "What a radical idea, the great gift that our Founders gave to us. " +
            "The freedom to chase our individual dreams through our sweat, and toil, " +
            "and imagination — and the imperative to strive together as well, to achieve a common good, a greater good. " +
            "For 240 years, our nation’s call to citizenship has given work and purpose to each new generation. " + 
            "It’s what led patriots to choose republic over tyranny, pioneers to trek west, slaves to brave that makeshift railroad to freedom. " +
            "It’s what pulled immigrants and refugees across oceans and the Rio Grande. " + 
            "It’s what pushed women to reach for the ballot. It’s what powered workers to organize. " +
            "It’s why GIs gave their lives at Omaha Beach and Iwo Jima; " +
            "Iraq and Afghanistan — and why men and women from Selma to Stonewall were prepared to give theirs as well.";
        
        StringTokenizer st = new StringTokenizer(sample, ".,-; ");

        // Map<String, Integer> map = new HashMap<>();
        TreeMap<String, Integer> map = new TreeMap<>();
        while(st.hasMoreTokens()) {
            String key = st.nextToken();
            Integer value = map.get(key.toLowerCase());
            map.put(key.toLowerCase(), (value==null?1:value+1));
        }
        System.out.println(map.size() + "개의 단어가 있습니다.");
        System.out.println(map);

        Set<String> keys = map.keySet();
        if (keys instanceof TreeSet)
            System.out.println("TreeSet!!!!");
        else System.out.println(keys.getClass().getName());
        // for (String key : keys) {
        //     System.out.println(key);
        // }

        Iterator<String> iter = keys.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        

        // PriorityQueue<String> words = new PriorityQueue<>();
        // Set<Entry<String, Integer>> entrySet = map.entrySet(); // java.util.Map.Entry
        // Iterator<Entry<String, Integer>> iter = entrySet.iterator();
        // while(iter.hasNext()) {
        //     Entry<String, Integer> entry = iter.next();
        //     String word = entry.getKey();
        //     words.offer(word);
        // }
        // Set<String> keySet = map.keySet();
        // words.addAll(keySet);
        // System.out.println("\n\n#####################################################");
        // int cnt = 1;
        // for (int i = 0; i < words.size(); i++) {
        //     String word = words.poll();
        //     System.out.println(word + ": " + map.get(word) );
        //     // if (cnt++ % 10 == 0) System.out.println();
        // }
        // System.out.println();
    }
}

class Student {
    int number;
    String name;

    public Student(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public String toString() {
        return "[name:"+ name + ", number:"+ number + "]";
    }
}
