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
    }

    public static void test() {
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

        Map<String, Integer> map = new HashMap<>();
        while(st.hasMoreTokens()) {
            String key = st.nextToken();
            Integer value = map.get(key);
            map.put(key, (value==null?1:value+1));
        }
        System.out.println(map.size() + "개의 단어가 있습니다.");
        System.out.println(map);

        PriorityQueue<String> words = new PriorityQueue<>();
        // Set<Entry<String, Integer>> entrySet = map.entrySet(); // java.util.Map.Entry
        // Iterator<Entry<String, Integer>> iter = entrySet.iterator();
        // while(iter.hasNext()) {
        //     Entry<String, Integer> entry = iter.next();
        //     String word = entry.getKey();
        //     words.offer(word);
        // }
        Set<String> keySet = map.keySet();
        words.addAll(keySet);
        System.out.println("\n\n#####################################################");
        int cnt = 1;
        for (int i = 0; i < words.size(); i++) {
            System.out.print(words.poll() + " ");
            if (cnt++ % 10 == 0) System.out.println();
        }
        System.out.println();
    }
}
