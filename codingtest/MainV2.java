package codingtest;

import java.util.Scanner;

public class MainV2 {
    public static void main(String[] args) {
        // caesarCipher();
        // arrayMultiply();
        // sumOfNsDivisor();
        makeWeirdString();

    }

    private static void makeWeirdString() {
        /*
            이상한 문자 만들기
            문제 설명
            문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 
            각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.

            제한 사항
            문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
            첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
            입출력 예
            s	return
            try hello world	TrY HeLlO WoRlD
            입출력 예 설명
            try hello world는 세 단어 try, hello, world로 구성되어 있습니다. 각 단어의 짝수번째 문자를 대문자로, 홀수번째 문자를 소문자로 바꾸면 TrY, HeLlO, WoRlD입니다. 따라서 TrY HeLlO WoRlD 를 리턴합니다.
        */
        String s = "try hello world";
        char[] result = new char[s.length()];
        // 공백을 만나면 cntIdx = 0으로 만들기.
        int cntIdx = 0;
        for (int i = 0; i < s.length(); i++) {
            result[i] = s.charAt(i);
            if (s.charAt(i) == ' ') {
                cntIdx = 0;
                continue;
            }
            if (cntIdx % 2 == 0) { // 짝수번째 알파벳이니까 대문자로 만들기.
                String tmp = result[i] + ""; // 문자열로 만든 다음, 문자열 클래스의 대문자 변환 메소드 이용. 
                result[i] = tmp.toUpperCase().charAt(0);
            } 
            cntIdx++;
        }
        String strResult = new String(result);
        System.out.println(strResult);
    }

    private static void sumOfNsDivisor() {
        /*
            약수의 합
            문제 설명
            정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.

            제한 사항
            n은 0 이상 3000이하인 정수입니다.
            입출력 예
            n	return
            12	28
            5	6
            입출력 예 설명
            입출력 예 #1
            12의 약수는 1, 2, 3, 4, 6, 12입니다. 이를 모두 더하면 28입니다.

            입출력 예 #2
            5의 약수는 1, 5입니다. 이를 모두 더하면 6입니다.
        */

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int sum = 0; 

        for (int i = 1; i <=n; i++) {
            if (n%i==0) { // 약수이면 
                sum += i;
            }
        }

        System.out.println(sum);
    }

    private static void arrayMultiply() {
        /*
            내적
            문제 설명
            길이가 같은 두 1차원 정수 배열 a, b가 매개변수로 주어집니다. a와 b의 내적을 return 하도록 solution 함수를 완성해주세요.

            이때, a와 b의 내적은 a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1] 입니다. (n은 a, b의 길이)

            제한사항
            a, b의 길이는 1 이상 1,000 이하입니다.
            a, b의 모든 수는 -1,000 이상 1,000 이하입니다.
            입출력 예
            a	b	result
            [1,2,3,4]	[-3,-1,0,2]	3
            [-1,0,1]	[1,0,-1]	-2
            입출력 예 설명
            입출력 예 #1

            a와 b의 내적은 1*(-3) + 2*(-1) + 3*0 + 4*2 = 3 입니다.
            입출력 예 #2
        */
        // int[] a = {1, 2, 3, 4};
        // int[] b = {-3, -1, 0, 2};

        int[] a = {-1, 0, 1};
        int[] b = {1, 0, -1};

        int sum = 0;
        /* i를 0 에서 n-1까지 반복하면서 
            sum += a[i]*b[i];
        */
        for (int i = 0; i < a.length; i++) {
            sum += a[i] * b[i];
        }
        System.out.println(sum);
    }

    private static void caesarCipher() {
        /*
        시저 암호
        문제 설명
        어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 
        예를 들어 AB는 1만큼 밀면 BC가 되고, 3만큼 밀면 DE가 됩니다. z는 1만큼 밀면 a가 됩니다. 
        문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.

        제한 조건
        공백은 아무리 밀어도 공백입니다.
        s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
        s의 길이는 8000이하입니다.
        n은 1 이상, 25이하인 자연수입니다.
        입출력 예
        s	n	result
        AB	1	BC
        z	1	a
        a B z	4	e F d
        */

        String source = "AB";
        source = "aBz";
        // source = "z";
        int n = 4;
        char[] result = new char[source.length()];

        for (int i = 0; i < source.length(); i++) {
            /* 
                소문자인 경우,  그 글자 + n이 
                            'z' 이하인 경우, 그 글자 + n 
                            'z' 초과인 경우, 'a' + (그 글자+n-'z'-1)
                                     
                대문자인 경우, 그 글자 + n이 
                            'Z' 이하인 경우, 그 글자 + n 
                            'Z' 초과인 경우, 'A' + (그 글자+n-'Z'-1)
                공배인 경우, 그대로 
            */
            char ch = source.charAt(i);
            char cch = (char)(ch + n); // 일단 n을 더해 놓고..
            if (ch != ' ') {
                if (ch >= 'a' && ch <= 'z' && cch > 'z') { // 소문자이고, n을 더했더니 'z'보다 큰 경우
                    cch = (char) ('a' + (cch-'z') - 1);
                } else if (ch >= 'A' && ch <= 'Z' && cch > 'Z') {//대문자이고, n을 더했더니 'Z'보다 큰 경우
                    cch = (char)('A' + (cch-'Z')-1);
                } 
            } else { // 공백인 경우.
                cch = ch; 
            }    
            
            result[i] = cch;
        }
        String strResult = new String(result);
        System.out.println(strResult);
    }
}
