package codingtest.test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {
    public static void main(String[] args) {
        //test01();
        //test02();
        //test03();
        //test04();
        //test05();
        //test06();
        //test07();
        //test08();
        //test09();
        //test10();
        //test11();
        //test12();
        //test13();
        test14();
    }

    private static void test01() {
        IntStream.range(1, 10)
        .forEach(System.out::print);

        System.out.println();
    }
    private static void test02() {
        IntStream
            .range(1, 10)
            .skip(5)
            .forEach(x->System.out.print(x + " "));

        System.out.println();
    }

    private static void test03() {
        System.out.println(IntStream.range(1, 5).sum());

        System.out.println();
    }

    private static void test04() {
        Stream.of("Ava", "Aneri", "Alberto").sorted().findFirst().ifPresent(System.out::println);
    }

    private static void test05() {
        String[] names = {"홍길동", "일지매", "김복동", "가락동", "성춘향", "이몽룡", "월매", "박문수"};
        Arrays.stream(names).filter(x->x.compareTo("이몽룡") < 0).sorted().forEach(System.out::println);
    }

    private static void test06() {
        Arrays.stream(new int[] {2, 4, 6, 8, 10}).map(x->x*x).average().ifPresent(System.out::println);
    }

    private static  void test07() {
        List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivia");
        people.stream().map(String::toLowerCase).filter(x->x.startsWith("a")).forEach(System.out::println);
    }

    private static void test08() {
        try {
            Stream<String> bands = Files.lines(Paths.get("bands.txt"));
            bands.filter(x->x.length() > 10).forEach(System.out::println);
            bands.close();
        }catch(Exception e) {e.printStackTrace();}
    }

    private static void test09() {
        try {
            List<String> bands2 = Files.lines(Paths.get("bands.txt")).filter(x->x.contains("jit")).collect(Collectors.toList());
            bands2.forEach(System.out::println);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    private static void test10() {
        try {
            Stream<String> rows1 = Files.lines(Paths.get("data.txt"));
            System.out.println(Paths.get("data.txt").toFile().getAbsolutePath());
            long rowCount = rows1.map(x->x.split(",")).filter(x->x.length==3).count();
            System.out.println(rowCount + " rows.");
            rows1.close();
        }catch(Exception e) {
            e.printStackTrace();
        } 
    }

    private static void test11() {
        try {
            Stream<String> rows1 = Files.lines(Paths.get("data.txt"));
            System.out.println(Paths.get("data.txt").toFile().getAbsolutePath());
            rows1.map(x->x.split(",")).filter(x->x.length==3).filter(x->Integer.parseInt(x[1]) > 15)
                    .forEach(x->System.out.println(x[0] + " " + x[1] + " " + x[2]));
            
            rows1.close();
        }catch(Exception e) {
            e.printStackTrace();
        } 
    }

    private static void test12() {
        try {
            Stream<String> rows1 = Files.lines(Paths.get("data.txt"));
            //System.out.println(Paths.get("data.txt").toFile().getAbsolutePath());
            Map<String, Integer> map = rows1.map(x->x.split(",")).filter(x->x.length==3).filter(x->Integer.parseInt(x[1]) > 15)
                    .collect(Collectors.toMap(x->x[0], x->Integer.parseInt(x[1]))); 
            rows1.close();

            for (String key : map.keySet()) {
                System.out.println(key + ":" + map.get(key));
            }
        }catch(Exception e) {
            e.printStackTrace();
        } 
    }

    private static void test13() {
        double total = Stream.of(7.3, 1.5, 4.8).reduce(0.0, (Double a, Double b) -> a + b);

        System.out.println("Total = " + total);
    }

    private static void test14() {
        IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10).summaryStatistics();

        System.out.println(summary);
    }
}