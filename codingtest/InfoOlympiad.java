package codingtest;

import java.util.Arrays;

public class InfoOlympiad {
    private static int diffBetweenMaxMin = -1;
    public static void main(String[] args) {
        // rockPaperScissors();
        crashPumpkin();
    }

    private static void crashPumpkin() {
        /*
         K개의 팀이 박 터트리기 게임을 한다. 각 팀은 하나의 바구니를 가지고 있고, 바구니에 들어있는 공들을 던져서 자기 팀의 박을 터트려야 한다. 
        
         우리는 게임을 준비하기 위해서, N개의 공들을 K개의 바구니에 나눠 담아야 한다. 이 때, 게임의 재미를 위해서 바구니에 
         담기는 공들을 개수를 모두 다르게 하고 싶다. 다시 말해서, N개의 공을 K개의 바구니에 빠짐없이 나누어 담는데, 각 바구니에는
         1개 이상의 공이 있어야 하고, 바구니에 담긴 공들의 개수는 모두 달라야 한다. 

         더불어, 게임의 불공정함을 줄이기 위해서, 가장 많이 담긴 바구니와 가장 적게 담긴 바구니의 공의 차이가 최소가 되도록 담을 것이다. 

         공들을 바구니에 나눠 담기 위한 규칙들을 정리하면 다음과 같다. 
         1) N개의 공을 K개의 바구니에 빠짐없이 나누어 담는다. 
         2) 각 바구니에는 1개 이상의 공이 들어 있어야 한다. 
         3) 각 바구니에 담긴 공들의 개수는 모두 달라야 한다. 
         4) 가장 많이 담긴 바구니와 가장 적게 담긴 바구니의 공의 개수 차이가 최소가 되어야 한다. 

         위 규칙들을 만족하여 N개의 공들을 K개의 바구니에 나눠 담을 때, 나눠 담을 수 있는지 여부를 결정하고, 담을 수 있을 때, 
         가장 많이 담긴 바구니와 가장 적게 담긴 바구니의 공의 개수 차이를 계산해서 출력하는 프로그램을 작성하시오. 

         입력 형식
         표준 입력으로 다음 정보가 주어진다. 첫 번째 줄에 공들의 개수를 나타내는 N과(2 ≤ N ≤ 100, 000) 팀 수를 나타내는 정수 
         K(2 ≤ K ≤ 1,000)가 주어진다. 

         출력 형식
         표준 출력으로 하나의 정수를 다음과 같이 출력하라. 
           N개의 공들을 K개의 바구니에 문제의 규칙을 만족하면서 나눠 담을 수 있다면, 가장 많이 담긴 바구니와 가장 적게 담긴 바구니의 공의 개수 차이를 출력하라. 
           N개의 공들을 K개의 바구니에 문제의 규칙을 만족하면서 나눠 담을 수 없다면 -1을 출력한다.

        추가 제약 조건
         20점 상당의 테스트 케이스는 K=2를 만족한다.
         20점 상담의 테스트 케이스는 K=3을 만족한다.
        */

        /*
            
            i를 1부터 N-1까지 다음을 반복한다. 
                i를 첫번째 원소로 하는 K-1개의 조합을 찾는다.          
                그 조합이 합이 N이면 최대값과 최소값의 차이를 비교한다. 그 전에 찾은 최대값과 최소값의 차이와 비교해 더 작은 것을 기억한다. 
        */
            int ballNums = 6;  // N
            int bagNums = 3;  // K
            int[] result = new int[bagNums];
            int startIdx = 0;
            combinations(result, ballNums, bagNums, startIdx);
            System.out.println(diffBetweenMaxMin);
    }
    

    private static void combinations(int[] arr, int n, int k, int idx) {
   
        if (k <= 0)  return ;

        for (int i = 1; i <= n-1; i++) {
            boolean alreadyIn = false;
            for (int j = 0; j < idx; j++) { // 이미 있는지 체크
                if (arr[j] == i) {
                    alreadyIn = true;
                    break;  // 이미 있으면 넣지 말고.
                }    
            }
            if (alreadyIn == false) { //없으면 넣고, 재귀호출
                arr[idx] = i;
                combinations(arr, n, k-1, idx+1) ;
            }
            // 지금 만들어진 조합의 합이 n이고, 마지막 위치를 위한 재귀호출이였으면, 그리고 이 i값이 마지막 원소로 선택되었으면 
            if (sum(arr) == n && idx == (arr.length-1) && arr[idx] != 0) {
                System.out.println(Arrays.toString((arr))); // 그 조합을 찍어본다. 
                int diff = diffMaxMin(arr);  // 이 조합의 최대값 최소값의 차이를 계산한다. 
                if (diffBetweenMaxMin  == -1 || diff < diffBetweenMaxMin) { // 기존 값보다 더 작으면 기억한다. 
                    diffBetweenMaxMin = diff;
                }
            }  
            arr[idx] = 0; // 다음 조합을 위해 0으로 초기화.
            
        }
        
    }

    private static int diffMaxMin(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 1 ; i < arr.length; i++) {
            if (min > arr[i]) min = arr[i];
            if (max < arr[i]) max = arr[i];
        }
        return max-min;
    }

    private static int sum(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        return total;
    }

    private static void rockPaperScissors() {
        /*
            A와 B가 가위바위보 게임을 한다. 
            5판 3선승제(다섯 판 중 세 판을 먼저 이기는 사람이 최종 승리)로 게임을 하는데 현재 A가 1승 0패인 상황이다.
            비기는 경우는 없어서 가위바위보를 한 번해서 이길 확률이 1/2일 때, A가 최종 승리하는 확률은 얼마인가?
        */

        /*
            A가 이기는 경우:
                남은 네판 중 두 번만 더 이기면 됨. 
                    win, win, win, win
                              win, lose
                              lose, win
                              lose, lose
                    win, lose, win, win
                                  , lose
                    win, lose, lose, win
                    lose, win, win, win
                                  , lose
                    lose, win, lose, win
                    lose, lose, win, win

                    
                    lose lose lose win
                    lose lose win lose
                    lose win lose lose
                    win lose lose lose
                    lose lose lose lose
        */
        // 16개의 경우의 수 중에서 이기는 경우는 11가지. 그래서 확률은 11/16 ?
    }
}
