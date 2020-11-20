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
        //ifSquareofNthenCalSquareOfNplusOne();
        // removeMinFromArray();
        // EvenOrOdd();

        // pressKeyPad();
        // getGCDLCM();
        // predictCollatz();
        // getAverage();
        // isHashyadNumber();
        // hidePhoneNumber();
        // matrixSum();
        // getNNumsStartFromXStepByX();
        // printRectangleStars();
        giveFundWithinBudget();
    }

    private static void giveFundWithinBudget() {
        /*
        문제 설명
        S사에서는 각 부서에 필요한 물품을 지원해 주기 위해 부서별로 물품을 구매하는데 필요한 금액을 조사했습니다. 
        그러나, 전체 예산이 정해져 있기 때문에 모든 부서의 물품을 구매해 줄 수는 없습니다. 
        그래서 최대한 많은 부서의 물품을 구매해 줄 수 있도록 하려고 합니다.

        물품을 구매해 줄 때는 각 부서가 신청한 금액만큼을 모두 지원해 줘야 합니다. 
        예를 들어 1,000원을 신청한 부서에는 정확히 1,000원을 지원해야 하며, 1,000원보다 적은 금액을 지원해 줄 수는 없습니다.

        부서별로 신청한 금액이 들어있는 배열 d와 예산 budget이 매개변수로 주어질 때, 
        최대 몇 개의 부서에 물품을 지원할 수 있는지 return 하도록 solution 함수를 완성해주세요.

        제한사항
        d는 부서별로 신청한 금액이 들어있는 배열이며, 길이(전체 부서의 개수)는 1 이상 100 이하입니다.
        d의 각 원소는 부서별로 신청한 금액을 나타내며, 부서별 신청 금액은 1 이상 100,000 이하의 자연수입니다.
        budget은 예산을 나타내며, 1 이상 10,000,000 이하의 자연수입니다.
        입출력 예
        d	budget	result
        [1,3,2,5,4]	9	3
        [2,2,3,3]	10	4
        입출력 예 설명
        입출력 예 #1
        각 부서에서 [1원, 3원, 2원, 5원, 4원]만큼의 금액을 신청했습니다. 
        만약에, 1원, 2원, 4원을 신청한 부서의 물품을 구매해주면 예산 9원에서 7원이 소비되어 2원이 남습니다. 
        항상 정확히 신청한 금액만큼 지원해 줘야 하므로 남은 2원으로 나머지 부서를 지원해 주지 않습니다. 위 방법 외에 3개 부서를 지원해 줄 방법들은 다음과 같습니다.

        1원, 2원, 3원을 신청한 부서의 물품을 구매해주려면 6원이 필요합니다.
        1원, 2원, 5원을 신청한 부서의 물품을 구매해주려면 8원이 필요합니다.
        1원, 3원, 4원을 신청한 부서의 물품을 구매해주려면 8원이 필요합니다.
        1원, 3원, 5원을 신청한 부서의 물품을 구매해주려면 9원이 필요합니다.
        3개 부서보다 더 많은 부서의 물품을 구매해 줄 수는 없으므로 최대 3개 부서의 물품을 구매해 줄 수 있습니다.

        입출력 예 #2
        모든 부서의 물품을 구매해주면 10원이 됩니다. 따라서 최대 4개 부서의 물품을 구매해 줄 수 있습니다.
        */

        /* 
            예산 신청 배열의 원소를 오름차순 정렬한다.
            순서대로 배정 예산을 넘지 않을 때까지 몇 번을 더할 수 있는지를 
            계산한다.
        */

        // int[] d = {1,3,2,5,4};
        // int budget = 9;
        int[] d = {2,2,3,3};
        int budget = 10;

        int answer = 0;

        Arrays.sort(d);

        int sum = 0;
        
        int i = 0;
        for (; i < d.length; i++) {
            sum += d[i];
            if (sum>= budget) {
                if (sum == budget)
                    answer = i+1;
                else 
                    answer = i;    
                break;
            }    
        }
        if (i  == d.length)
            answer = d.length;

        System.out.println(answer);
        System.out.println(Arrays.toString(d));
    }

    private static void printRectangleStars() {
        /*
            직사각형 별찍기
            문제 설명
            이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
            별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.

            제한 조건
            n과 m은 각각 1000 이하인 자연수입니다.
            예시
            입력

            5 3
            출력

            *****
            *****
            *****
        */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
       
    }

    private static void getNNumsStartFromXStepByX() {
        /*
            x만큼 간격이 있는 n개의 숫자
            문제 설명
            함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 
            다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.

            제한 조건
            x는 -10000000 이상, 10000000 이하인 정수입니다.
            n은 1000 이하인 자연수입니다.
            입출력 예
            x	n	answer
            2	5	[2,4,6,8,10]
            4	3	[4,8,12]
            -4	2	[-4, -8]        
        */
        int x = 2;
        int n = 5;

        // x = 4;
        // n = 3;
        
        x = -4;
        n = 2;

        long longx = x; // 값이 정수의 수용 범위를 넘을 수 있기 때문에 반드시 long 변수에 담아 계산해야 됨!!!! 주의하기!!!!

        long[] answer = new long[n];
        answer[0] = longx;
        
        for (int i = 1; i < n; i++) {
            answer[i] = longx + longx*i;
        }
        System.out.println(Arrays.toString(answer));

    }

    private static void matrixSum() {
      /*
        행렬의 덧셈
        문제 설명
        행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다. 
        2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.

        제한 조건
        행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.
        입출력 예
        arr1	arr2	return
        [[1,2],[2,3]]	[[3,4],[5,6]]	[[4,6],[7,9]]
        [[1],[2]]	[[3],[4]]	[[4],[6]]
      */
        int[][] arr1 = {{1,2}, {2,3}};
        int[][] arr2 = {{3,4}, {5,6}};

        int[][] answer = new int[arr1.length][arr1[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        for (int i = 0; i < answer.length; i++)
            System.out.println(Arrays.toString(answer[i]));
        

    }

    private static void hidePhoneNumber() {
        /*
        핸드폰 번호 가리기
        문제 설명
        프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
        전화번호가 문자열 phone_number로 주어졌을 때, 
        전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.

        제한 조건
        s는 길이 4 이상, 20이하인 문자열입니다.
        입출력 예
        phone_number	return
        01033334444	*******4444
        027778888	*****8888
        */

        String answer = "";

        String phone_number = "01033334444";
        phone_number = "027778888";

        int i = 0;
        for (; i < phone_number.length()-4; i++) {
            answer += "*";
        }
        for ( ; i < phone_number.length(); i++) {
            answer += phone_number.charAt(i);
        }
        System.out.println(answer);
    }

    private static void isHashyadNumber() {
        /*
        하샤드 수
        문제 설명
        양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다. 예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다. 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.

        제한 조건
        x는 1 이상, 10000 이하인 정수입니다.
        입출력 예
        arr	return
        10	true
        12	true
        11	false
        13	false
        입출력 예 설명
        입출력 예 #1
        10의 모든 자릿수의 합은 1입니다. 10은 1로 나누어 떨어지므로 10은 하샤드 수입니다.

        입출력 예 #2
        12의 모든 자릿수의 합은 3입니다. 12는 3으로 나누어 떨어지므로 12는 하샤드 수입니다.

        입출력 예 #3
        11의 모든 자릿수의 합은 2입니다. 11은 2로 나누어 떨어지지 않으므로 11는 하샤드 수가 아닙니다.
        */
        int x = 10;
        x = 12;
        x = 11;
        x = 13;
        boolean answer = true;
        int sumOfDigits = 0;
        int org_x = x;

        while(x > 0) {
            int digit = x % 10;
            sumOfDigits += digit;
            x = x/10;
        }
        answer = org_x%sumOfDigits==0;
        System.out.println(answer);
        
    }

    private static void getAverage() {
        /*
        평균 구하기
        문제 설명
        정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.

        제한사항
        arr은 길이 1 이상, 100 이하인 배열입니다.
        arr의 원소는 -10,000 이상 10,000 이하인 정수입니다.
        입출력 예
        arr	return
        [1,2,3,4]	2.5
        [5,5]	5
        */

        // int[] arr = {1, 2, 3, 4};
        int[] arr = {5,5};
        double answer = 0;

        double sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        answer = sum/arr.length;
        System.out.println(answer);
    }

    private static void predictCollatz() {
        /*
            콜라츠 추측
            문제 설명
            1937년 Collatz란 사람에 의해 제기된 이 추측은, 주어진 수가 1이 될때까지 다음 작업을 반복하면, 
            모든 수를 1로 만들 수 있다는 추측입니다. 작업은 다음과 같습니다.

            1-1. 입력된 수가 짝수라면 2로 나눕니다. 
            1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
            2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
            예를 들어, 입력된 수가 6이라면 6→3→10→5→16→8→4→2→1 이 되어 총 8번 만에 1이 됩니다. 
            위 작업을 몇 번이나 반복해야하는지 반환하는 함수, solution을 완성해 주세요. 
            단, 작업을 500번을 반복해도 1이 되지 않는다면 –1을 반환해 주세요.

            제한 사항
            입력된 수, num은 1 이상 8000000 미만인 정수입니다.
            입출력 예
            n	result
            6	8
            16	4
            626331	-1
            입출력 예 설명
            입출력 예 #1
            문제의 설명과 같습니다.

        */
        long n = 6;  
        n = 16;
        n = 626331;  // long으로 선언하지 않으면 중간에 오버플로우가 발생해 잘못된 결과가 나옴!!!! 주의하기!!!!!
        int cnt = 0;

        while (n != 1) {
            if (n%2==0) {
                n = n/2;
            } 
            else { 
                n = n*3+1;
            }
            // System.out.println(n);    
            cnt++;
            if (cnt >=500) {
                System.out.println("500번째 시도!!!");
                break;
            } 
        }
        if (n == 1) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
        
    }

    private static void getGCDLCM() {
        /*
        최대공약수와 최소공배수
        문제 설명
        두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다. 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.

        제한 사항
        두 수는 1이상 1000000이하의 자연수입니다.
        입출력 예
        n	m	return
        3	12	[3, 12]
        2	5	[1, 10]
        입출력 예 설명
        입출력 예 #1
        위의 설명과 같습니다.

        입출력 예 #2
        자연수 2와 5의 최대공약수는 1, 최소공배수는 10이므로 [1, 10]을 리턴해야 합니다.
        */

        int n = 3;
        int m = 12;
        n = 2; 
        m = 5;
        if (n > m) {
            int tmp = n;
            n = m;
            m = tmp;
        }
        int multiple = n * m;
        /*
            최대 공약수
            1. n이 0이면 최대공약수는 m
            2. r = m%n
            3. m = n
            4. n = r
            5. 1번으로 

        */
        while (n != 0) {
            int r = m%n;
            m = n;
            n = r;
        }
        // 최소공배수는 n*m/최대공약수
        int[] result = {m, multiple/m};
        System.out.println(Arrays.toString(result));
    }

    private static void pressKeyPad() {
        /*
            [카카오 인턴] 키패드 누르기

            1   2   3
            4   5   6
            7   8   9
            *   0   # 

             이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
            맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.

            엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
            왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
            오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
            가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
            4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
            순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때, 
            각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.

            [제한사항]
            numbers 배열의 크기는 1 이상 1,000 이하입니다.
            numbers 배열 원소의 값은 0 이상 9 이하인 정수입니다.
            hand는 "left" 또는 "right" 입니다.
            "left"는 왼손잡이, "right"는 오른손잡이를 의미합니다.
            왼손 엄지손가락을 사용한 경우는 L, 오른손 엄지손가락을 사용한 경우는 R을 순서대로 이어붙여 문자열 형태로 return 해주세요.
            입출력 예
            numbers	hand	result
            [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	"right"	"LRLLLRLLRRL"
            [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	"left"	"LRLLRRLLLRR"
            [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]	"right"	"LLRLLRLLRL"
            입출력 예에 대한 설명
            입출력 예 #1

            순서대로 눌러야 할 번호가 [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]이고, 오른손잡이입니다.

            왼손 위치	오른손 위치	눌러야 할 숫자	사용한 손	설명
            *	#	1	L	1은 왼손으로 누릅니다.
            1	#	3	R	3은 오른손으로 누릅니다.
            1	3	4	L	4는 왼손으로 누릅니다.
            4	3	5	L	왼손 거리는 1, 오른손 거리는 2이므로 왼손으로 5를 누릅니다.
            5	3	8	L	왼손 거리는 1, 오른손 거리는 3이므로 왼손으로 8을 누릅니다.
            8	3	2	R	왼손 거리는 2, 오른손 거리는 1이므로 오른손으로 2를 누릅니다.
            8	2	1	L	1은 왼손으로 누릅니다.
            1	2	4	L	4는 왼손으로 누릅니다.
            4	2	5	R	왼손 거리와 오른손 거리가 1로 같으므로, 오른손으로 5를 누릅니다.
            4	5	9	R	9는 오른손으로 누릅니다.
            4	9	5	L	왼손 거리는 1, 오른손 거리는 2이므로 왼손으로 5를 누릅니다.
            5	9	-	-	
            따라서 "LRLLLRLLRRL"를 return 합니다.

            입출력 예 #2

            왼손잡이가 [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]를 순서대로 누르면 사용한 손은 "LRLLRRLLLRR"이 됩니다.

            입출력 예 #3

            오른손잡이가 [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]를 순서대로 누르면 사용한 손은 "LLRLLRLLRL"이 됩니다.  
        */

        // int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        // String leftOrRightHanded = "right";

        // int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        // String leftOrRightHanded = "left";

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String leftOrRightHanded = "right";

        String[] result = new String[numbers.length];

        String whichHand = null;  // 어느 손을 사용할지, 일단 왼손으로 초기화. 
        int left = -1; // 왼손이 별표에 있음을 의미
        int right = -1; // 오른손이 별표에 있음을 의미

        for (int i = 0; i < numbers.length; i++) {
            switch(numbers[i]) {
                // 3, 6, 9를 누를 땐 오른쪽 엄지 사용.
                case 3:
                case 6:
                case 9:
                    whichHand = "R";
                    right = numbers[i]; // 오른 손가락의 마지막 위치 기억
                    break;
                /* 2, 5, 8, 0을 누를 땐 현재 왼쪽과 오른쪽 손가락으로부터의 거리를 계산해서 최단거리의 손을 사용. 
                 거리가 같을 땐, 오른손잡이는 오른손, 왼손잡이는 왼손 사용 */
                case 2:
                case 5:
                case 8:
                case 0:                    
                    whichHand = calculateDistance(left, right, leftOrRightHanded, numbers[i]);  
                    if (whichHand.equals("L")) { // 왼 손가락의 마지막 위치 기억
                        left = numbers[i];
                    } else { // 오른 손가락의 마지막 위치 이용
                        right = numbers[i];
                    }
                    break;
                default : // 1, 4, 7, 0은 왼손
                    whichHand = "L";
                    left = numbers[i]; // 왼 손가락의 마지막 위치 기억 
            }

            result[i] = whichHand;
        }

        System.out.println(Arrays.toString(result));

    }

    private static String calculateDistance(int left, int right, String leftOrRight, int keyPadNum) {
        String resultHand = null;

        int distanceFromLeft = 1;
        int distanceFromRight = 1;

        // 눌러야할 키패드가 0, 1, 2, 3, ... 9일 경우, 그 키패드로부터 0, 1, 2, 3, ... 9, *, # 까지의 거리를 저장.
        // 눌러야 할 키패드가 0이고 현재 손가락의 위치가 5라면, distances[0][5]에 그 거리가 있음. 
        // 눌러야 할 키패드가 0이고 현재 손가락의 위치가 *이면, distances[0][10]에 그 거리가 있음
        // 눌러야 할 키패드가 0이고 현재 손가락의 위치가 #이면, distances[0][11]에 그 거리가 있음
        int[][] distances = {{0, 4, 3, 4, 3, 2, 3, 2, 1, 2, 1, 1}, {4, 0, 1, 2, 1, 2, 3, 2, 3, 4, 3, 5}, 
                             {3, 1, 0, 1, 2, 1, 2, 3, 2, 3, 4, 4}, {4, 2, 1, 0, 2, 2, 1, 4, 3, 2, 5, 3}, 
                             {3, 1, 2, 3, 0, 1, 2, 1, 2, 3, 2, 4}, {2, 2, 1, 2, 1, 0, 1, 2, 1, 2, 3, 3}, 
                             {3, 3, 2, 1, 2, 1, 0, 3, 2, 1, 4, 2}, {2, 2, 3, 4, 1, 2, 3, 0, 1, 2, 1, 3}, 
                             {1, 3, 2, 3, 2, 1, 2, 1, 0, 1, 2, 2}, {2, 4, 3, 2, 3, 2, 1, 2, 1, 0, 3, 1} , 

                        }; 
   
        if (left == -1) { //왼 손이 *에 있다. 
            left = 10;
        }             
        if (right == -1) { //오른 손이 #에 있다. 
            right = 11;
        }   

        distanceFromLeft = distances[keyPadNum][left];
        distanceFromRight = distances[keyPadNum][right];
        
        System.out.println("keyPad: " + keyPadNum + ", left:" + left + ", right:" + right);
        System.out.println("distanceFromLeft: " + distanceFromLeft + ", distanceFromRight:" + distanceFromRight) ;
        System.out.println("\n");

        if (distanceFromLeft < distanceFromRight) 
                        resultHand = "L";
        else if (distanceFromLeft > distanceFromRight)
                        resultHand = "R";
        else { // 거리가 같으면 왼손잡이, 오른손잡이에 따라 결정
            if (leftOrRight.equals("left"))
                resultHand="L";
            else 
                resultHand="R";
        }

        return resultHand;
    }


    private static void EvenOrOdd() {
        /*
            짝수와 홀수
            문제 설명
            정수 num이 짝수일 경우 Even을 반환하고 홀수인 경우 Odd를 반환하는 함수, solution을 완성해주세요.

            제한 조건
            num은 int 범위의 정수입니다.
            0은 짝수입니다.
            입출력 예
            num	return
            3	Odd
            4	Even

        */
        int n = 3;
        n = 4;

        if (n%2==0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }

    private static void removeMinFromArray() {
        /*
            제일 작은 수 제거하기
            문제 설명
            정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. 
            단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 
            예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.

            제한 조건
            arr은 길이 1 이상인 배열입니다.
            인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.
            입출력 예
            arr	return
            [4,3,2,1]	[4,3,2]
            [10]	[-1]

        */


        // int[] arr = {4, 3, 2, 1};
        // int[] arr = {10};
        int[] arr = {5, 398, 23, 523, 90, 324, 4};
        int[] result = null;
        if (arr.length <= 1) {
            result = new int[1];
            result[0] = -1;
            System.out.println(Arrays.toString(result));
            return;    // 메소드 종료 
        } else {  // 결과 배열의 크기는 원래 배열의 크기 - 1 
            result = new int[arr.length-1];
        }

        // 배열에서 제일 작은 값의 인덱스 찾기.
        int minIdx = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[minIdx] > arr[i]) {
                minIdx = i;
            }
        }
        int idx = 0; // 결과 배열의 인덱스 
        // 최소값을 제외한 나머지 arr배열의 원소를 result 배엘에 복사 
        for (int i = 0; i < arr.length; i++) {
            if (i != minIdx) {
                result[idx++] = arr[i];
            }
        }

        System.out.println(Arrays.toString(result));


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
