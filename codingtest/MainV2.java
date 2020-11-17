package codingtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainV2 {
    public static void main(String[] args) {
        // caesarCipher();
        // arrayMultiply();
        // sumOfNsDivisor();
        // makeWeirdString();
        // sumEachDigit();
        // makeArrayFromReversedDigitsOfInteger();
        // sortDigitsInDescendingOrder();
        ifSquareofNthenCalSquareOfNplusOne();
    }

    private static void ifSquareofNthenCalSquareOfNplusOne() {
        /*
            정수 제곱근 판별
            문제 설명
            임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
            n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.

            제한 사항
            n은 1이상, 50000000000000 이하인 양의 정수입니다.
            입출력 예
            n	return
            121	144
            3	-1
            입출력 예 설명
            입출력 예#1
            121은 양의 정수 11의 제곱이므로, (11+1)를 제곱한 144를 리턴합니다.

            입출력 예#2
            3은 양의 정수의 제곱이 아니므로, -1을 리턴합니다.
        */

        int n = 121;
        n =3;
        n = 225;
        int square = 1;

        while (square*square < n) {
            square++;
        }
        if(square*square == n) {
            System.out.println((square+1)*(square+1));
        } else {
            System.out.println(-1);
        }
    }

    private static void sortDigitsInDescendingOrder() {
        /*
            정수 내림차순으로 배치하기
            문제 설명
            함수 solution은 정수 n을 매개변수로 입력받습니다. 
            n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 
            예를들어 n이 118372면 873211을 리턴하면 됩니다.

            제한 조건
            n은 1이상 8000000000 이하인 자연수입니다.
            입출력 예
            n	return
            118372
        */

        // 1의 자리부터 가장 큰 자리까지의 수를 정수 배열에 넣는다.

        int n = 118372;
        int size = 0;

        int tmp = n;
        // digit의 갯수 계산
        while(tmp > 0) {
            tmp = tmp/10;
            size++;
        }
        int[] result = new int[size];

        // 1의 자리부터 가장 큰 자리까지의 숫자를 추출해서 배열에 저장한다. 
        int idx = 0;
        while(n > 0) {
            int digit = n % 10;
            result[idx++] = digit;
            n = n/10;
        }

        // result 배열에 저장된 수를 오름차순으로 정렬한다. 
        // 만만한 선택정렬 사용.

        for (int i = 0; i < result.length; i++) {
            int minIdx = i; 
            for (int j = i; j < result.length; j++) {
                if (result[minIdx] > result[j]) {
                    minIdx = j;
                }
            }
            int tmpValue = result[i];
            result[i] = result[minIdx];
            result[minIdx] = tmpValue;
        }

        // 내림차순으로 정렬된 숫자에 자리수 값을 곱해서 더한다. 
        // 첫 번째 원소가 1의 자리, 두 번째 원소가 10의 자리 ...
        int resultValue = 0;
        int positionValue = 1;
        for (int i = 0; i < result.length; i++) {
            resultValue +=  (result[i]*positionValue);
            positionValue *= 10; // 자리 수 값은 10배씩 커진다. 
        }

        System.out.println(resultValue);


    }
    private static void makeArrayFromReversedDigitsOfInteger() {
        /*
            자연수 뒤집어 배열로 만들기
            문제 설명
            자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

            제한 조건
            n은 10,000,000,000이하인 자연수입니다.
            입출력 예
            n	return
            12345	[5,4,3,2,1]
        */

        int n = 12345;
        /*
            n이 0보다 큰동안 다음을 반복하면 1의 자리부터 가장 큰 자리까지의 숫자를 추출할 수 있다. 
                int digit = n % 10;
                digit를 ArrayList에 추가.
                n = n/10;

        */
        ArrayList<Integer> list = new ArrayList<>();
        while(n > 0) {
            int digit = n % 10;
            list.add(digit);
            n = n/10;
        }

        Integer[] result = list.toArray(new Integer[list.size()]);
        System.out.println(Arrays.toString(result));

    }

    private static void sumEachDigit() {
        /*
            자릿수 더하기
            문제 설명
            자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
            예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.

            제한사항
            N의 범위 : 100,000,000 이하의 자연수
            입출력 예
            N	answer
            123	6
            987	24
            입출력 예 설명
            입출력 예 #1
            문제의 예시와 같습니다.

            입출력 예 #2
            9 + 8 + 7 = 24이므로 24를 return 하면 됩니다.
        */

        int n = 123;
        n = 987;

        /*
            아래 작업을 n이 0보다 큰 동안 반복한다. 
                int digit = n%10; //10으로 나눈 나머지로 첫 번째 숫자를 구한다. 
                sum += digit
                n = n/10; // n을 10으로 나눈다.
        */
        int sum = 0;
        while (n > 0) {
            int digit = n%10;
            sum += digit;
            n = n/10;
        }

        System.out.println(sum);

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
