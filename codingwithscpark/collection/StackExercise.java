package codingwithscpark.collection;

import java.util.*;

public class StackExercise {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // stringTokenizerTest();
        System.out.println("수식을 입력하시오.");
        String exp = input.nextLine();

        StringTokenizer st = new StringTokenizer(exp, " "); // 문자열을 구분자를 기준으로 토큰으로 분리해줌.
        // while(st.hasMoreTokens()) {
        //     System.out.println("["+st.nextToken()+"]");
        // }

        Stack<String> stack = new Stack<>();
        while(st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.equals("("))
                stack.push(token);
            else if (token.equals(")")) {
                if (stack.isEmpty() == false) stack.pop();
                else {
                    System.out.println("유효하지 않은 식입니다.");
                    return;
                }
            }
        }
       

        if (stack.isEmpty()) System.out.println("유효한 식입니다.");
        else System.out.println("유효하지 않은 식입니다.");
 
    }

    public static void stringTokenizerTest() {
        StringTokenizer st = new StringTokenizer("APPLE, GRAPE, BANANA, MELON, STRAWBERRY", ", ");
        while(st.hasMoreTokens()) {
            System.out.println("["+st.nextToken()+"]");
        }
    }
}
