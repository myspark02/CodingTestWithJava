package codingtest;

import java.util.*;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
       // System.out.println("Hello goorm!");
        //removeConsecutiveDuplicates();
        //addTwoValuesFromDifferentIndexes();
        // String[] participants = {"leo", "kiki", "eden"};
        // String[] completion = {"eden", "kiki"};
        // String[] participants = {"marina", "josipa", "nikola", "vinko", "filipa"};
        // String[] completion = {"josipa", "filipa", "marina", "nikola"};
        /*
        String[] participants = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        pickOutNotCompletedParticipant(participants, completion);
        */
        // getTheGiviUpsMath();
        
        //stolenAthleteSuit();
        //kthNumber();
        //twoThoundsSixteen();
        //ternaryFlipFlop();
        //pickOutMiddle();
        // filterElementsDividedBySpecifiedNumber();
        sumBetweenTwoNumbers();
    }

    private static void sumBetweenTwoNumbers() {
        /*
            두 정수 사이의 합
            문제 설명
            두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
            예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.

            제한 조건
            a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
            a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
            a와 b의 대소관계는 정해져있지 않습니다.
            입출력 예
            a	b	return
            3	5	12
            3	3	3
            5	3	12
        */


        int start = 3;
        int end = 5;

        start = 3;
        end = 3;

        start = 5;
        end = 3;

        if (start > end) {
            int tmp = start;
            start = end;
            end = tmp;
        }

        int sum = 0;
        for (int i = start; i <=end; i++) {
            sum += i;

        }

        System.out.println(sum);
    }

    private static void filterElementsDividedBySpecifiedNumber() {
        /*
            나누어 떨어지는 숫자 배열
            문제 설명
            array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
            divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.

            제한사항
            arr은 자연수를 담은 배열입니다.
            정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
            divisor는 자연수입니다.
            array는 길이 1 이상인 배열입니다.
            입출력 예
            arr	divisor	return
            [5, 9, 7, 10]	5	[5, 10]
            [2, 36, 1, 3]	1	[1, 2, 3, 36]
            [3,2,6]	10	[-1]
            입출력 예 설명
            입출력 예#1
            arr의 원소 중 5로 나누어 떨어지는 원소는 5와 10입니다. 따라서 [5, 10]을 리턴합니다.

            입출력 예#2
            arr의 모든 원소는 1으로 나누어 떨어집니다. 원소를 오름차순으로 정렬해 [1, 2, 3, 36]을 리턴합니다.

        */


        int[] arr = {5, 9, 7, 10};
        int divisor = 5;

        // int[] arr = {2, 36, 1, 3};
        // int divisor = 1;

        // int[] arr = {3, 2, 6};
        // int divisor = 10;

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                result.add(arr[i]);
            }
        }

        if (result.size() == 0) {
            result.add(-1);
        }

        Integer[] resultArr = result.toArray(new Integer[result.size()]);

        Arrays.sort(resultArr);
        
        
        System.out.println(Arrays.toString(resultArr));
        



    }
    
    private static void pickOutMiddle() {
        /*
        
            가운데 글자 가져오기
            문제 설명
            단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

            재한사항
            s는 길이가 1 이상, 100이하인 스트링입니다.
            입출력 예
            s	return
            abcde	c
            qwer	we
               
        */
        
        String s = "abcde";
        s = "qwer";
        if (s.length() % 2 != 0) {
            System.out.println(s.charAt(s.length()/2));
        } else {
            System.out.println(s.charAt(s.length()/2-1) + "" + s.charAt(s.length()/2));
        }
    }
    
    private static void ternaryFlipFlop() {
        /*
        3진법 뒤집기
        문제 설명
        자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.

        제한사항
        n은 1 이상 100,000,000 이하인 자연수입니다.
        입출력 예
        n	result
        45	7
        125	229
        입출력 예 설명
        입출력 예 #1

        답을 도출하는 과정은 다음과 같습니다.
        n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
        45	1200	0021	7
        따라서 7을 return 해야 합니다.
        */
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        
        /* 3진법으로 변환 & 뒤집기*/
        String ternary = "";
        while(n!=0) {
            ternary += n%3;
            n /= 3;
        }
        
        System.out.println(ternary);
        double sum = 0.0;
        int powNum = 0;
        // 10진법으로 변환 
        for (int i = ternary.length()-1; i >=0 ;i--) {
            double mul = Math.pow(3, powNum++);
            System.out.println("mul:"+ mul);
            int multiplicand = Integer.parseInt(""+ternary.charAt(i));
            System.out.println("multiplicand:"+multiplicand);
            sum += multiplicand * mul;
        }
        
        System.out.println((int)sum);
    }
    
    private static void twoThoundsSixteen() {
        /*
            2016년
            문제 설명
            2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, 
            solution을 완성하세요. 요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT입니다. 
            예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 TUE를 반환하세요.

            제한 조건
            2016년은 윤년입니다.
            2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
            입출력 예
            a	b	result
            5	24	TUE            
        */
        String[] daysOfTheWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        /*
            4, 6, 9, 11월 : 30일
            1, 3, 5, 7, 8, 10, 12월 : 31일
            2월 : 29일
            
        */
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        Scanner input = new Scanner(System.in);
        int month = input.nextInt();
        int day = input.nextInt();
        
        int daysForMonths = 0;
        /* 1월 1일부터 입력된 날짜까지 경과된 날 수를 구한다. 
           입력된 월이 1이면, 경과된 날짜는 day - 1;
           그렇지 않으면 
            30 + 2월부터 month - 1까지의 일수 + day 
        */
        if (month < 2) {
            daysForMonths = day - 1;
        } else {
            daysForMonths = 30;
            for (int i = 1; i < month-1; i++) 
                daysForMonths += days[i];
            daysForMonths += day;
        }
        
        /*
            daysForMonths를 7로 나눈 나머지 값을 구하고. 그 값만큼 지난 요일을 알아낸다. 
        */
        System.out.println(daysForMonths);
        
        daysForMonths %= 7;
        
        System.out.println(daysForMonths);
        
        System.out.println(daysOfTheWeek[(daysForMonths+5)%7]);
        
        input.close();
        
    }
    
    private static void kthNumber() {
        /*
        K번째수
        문제 설명
        배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

        예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

        array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
        1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
        2에서 나온 배열의 3번째 숫자는 5입니다.
        배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 
        배열에 담아 return 하도록 solution 함수를 작성해주세요.

        제한사항
        array의 길이는 1 이상 100 이하입니다.
        array의 각 원소는 1 이상 100 이하입니다.
        commands의 길이는 1 이상 50 이하입니다.
        commands의 각 원소는 길이가 3입니다.
        입출력 예
        array	commands	return
        [1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]

        */
        
        int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};
        int[] array = {1,5,2,6,3,7,4};
        
        int[] result = new int[commands.length];
        int[] tmp = null; // array의 길이가 1~100 이므로 
        
        /*  
            for each element of commands repeat the followings
                array의 index (commands[i][0] - 1) 부터  (commands[i][1] - 1)까지의 원소를 임시 배열에 저장
                그 임시 배열의 원소들을 오름차순으로 정렬
                그 정렬된 임시 배열에서 index (commands[i][2]-1)의 원소를 result[i]에 저장.
        */
        for (int i = 0; i < commands.length; i++) {
            int idx = 0; 
            tmp = new int[commands[i][1]-commands[i][0]+1];
            for (int j=commands[i][0]-1; j < commands[i][1]; j++) {
                tmp[idx++] = array[j];
            }
            Arrays.sort(tmp);
            //print(tmp);
            result[i] = tmp[commands[i][2]-1];
        }
        
        for(int n : result) {
            System.out.print(n + " ");
        }
        
        System.out.println();
    }
    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    private static void stolenAthleteSuit() {
        /*
            문제 설명
            점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 학생들의 번호는 
            체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 
            체육복을 빌려줄 수 있습니다. 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.

            전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 
            체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.

            제한사항
            전체 학생의 수는 2명 이상 30명 이하입니다.
            체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
            여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
            여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
            여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 
            체육복을 빌려줄 수 없습니다.
            입출력 예
            n	lost	reserve	return
            5	[2, 4]	[1, 3, 5]	5
            5	[2, 4]	[3]	4
            3	[3]	[1]	2

            n - # of lost + # of possible borrows
            
            # of possible borrows : lost[i] - 1 or lost[i] + 1 is in reserve, if borrow then mark it as borrowed by assiging -1 
            to borrows[k] where k is index of borrows holding the borrower
        */
        
        int n = 3;
        int[] lost = {2, 4};
        lost = new int[]{3};
       
        int[] reserve = {1, 3, 5};
        //reserve = new int[]{3};
        reserve = new int[]{1};
        
        int result = n - lost.length;
        
        int borrowCnt = 0;
        
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == lost[i] - 1 || reserve[j] == lost[i] + 1) {
                    borrowCnt++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        result += borrowCnt;
        
        System.out.println(result);
        
    }
    
    private  static void pickOutNotCompletedParticipant(String[] participants, String[] completion) {
        int i = 0; 
        for (; i < participants.length; i++) {
            boolean found = false;
            for (int j = 0; j < completion.length; j++) {
                if (participants[i].equals(completion[j])) {
                    found = true;
                    completion[j] = "";
                    break;
                }
            }
            if (found == false) break;
        }
        System.out.println(participants[i]);
    }
    
    private static void addTwoValuesFromDifferentIndexes() {
        //int[] numbers = {2,1,3,4,1};
        int[] numbers = {5, 0, 2, 7};
        
        int sum = 0; 
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j) {
                    sum = numbers[i] + numbers[j];
                    System.out.print(sum + " ");
                    set.add(sum);
                }
            }
        }
        System.out.println();
        int[] outputArr = new int[set.size()];
        int idx = 0;
        for (int n : set) {
            System.out.print(n + " ");
            outputArr[idx++] = n;
        }
        System.out.println();
        for (int i = 0; i < outputArr.length; i++) {
            System.out.print(outputArr[i]+" ");
        }
        System.out.println();
    }
    
    private static void removeConsecutiveDuplicates() {
       // int[] inputArr = {1,1, 3, 3, 0, 1, 1};
         int[] inputArr = {4,4,4,3,3};
        
        int previousValue = inputArr[0];
        int count = 1; // number of elements in output array

        for (int i = 1 ; i < inputArr.length; i++) {
            if (previousValue != inputArr[i]) {
                count++;
                previousValue = inputArr[i];
            }   
        }
        System.out.println(count);
        
        int[] outputArr = new int[count];
        
        count = 0;
        outputArr[count] = inputArr[0];
        for (int i = 1 ; i < inputArr.length; i++) {
            if (outputArr[count] != inputArr[i]) {
               outputArr[++count] = inputArr[i];
            } 
        }
        
        for (int i = 0; i < outputArr.length; i++)
            System.out.print(outputArr[i] + " ");
        System.out.println();
    }

}
