package codingtest.test;

import java.util.*;

public class EnumExamples {

    public static void main(String[] args) {
        // Level level = Level.HIGH;
        
        // if (level == Level.HIGH) {

        // } else if (level == Level.MEDIUM) {

        // } else {

        // }

        // switch(level) {
        //     case HIGH:
        //         System.out.println(Level.HIGH); 
        //         break;
        //     case MEDIUM:
        //         System.out.println(Level.MEDIUM); 
        //         break;
        //     case LOW:
        //         System.out.println(Level.LOW); 
        //         break;                

        // }

        // Level[] values = Level.values();

        // for (Level aLevel : values)
        //      System.out.println(aLevel);

        // Level low = Level.valueOf("LOW");
        // System.out.println(low);
        // System.out.println(low.getLevel());

        // System.out.println(Level.HIGH.normalize());
        // System.out.println(Level.MEDIUM.normalize());
        // System.out.println(Level.LOW.normalize());

        EnumSet enumSet = EnumSet.of(Level.HIGH, Level.MEDIUM);
        System.out.println(enumSet);

        EnumMap<Level, String> enumMap = new EnumMap<>(Level.class);
        enumMap.put(Level.HIGH, "High value");
        enumMap.put(Level.LOW, "Low value");
        System.out.println(enumMap);

    
    }
    

 
}
