package codingtest.test;

import java.util.Arrays;
import java.util.Scanner;

public class Practice {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        //testAlaram();
        //testFor();
        //printStars01();
        // printStars02();
        ticTacToe();
        
    }   

    private static void ticTacToe() {
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        Scanner input = new Scanner(System.in);
        boolean isOver = false;
        while(true) {
            display(board);
            if (isOver) {
                System.out.println("게임을 종료합니다.");
                break;
            }
            System.out.println("다음 좌표를 입력하세요.");
            int row = input.nextInt();
            int col = input.nextInt();

            if (board[row][col] == ' ') {
                board[row][col] = 'X';
            } else {
                System.out.println("잘못된 좌표입니다.");
                continue;
            }
            if(nextPosition(board, 'O') == false) {
                isOver = true;
            }
        }
    }

    private static void display(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (j < board[i].length - 1) {
                    System.out.print(board[i][j] + " | ");
                } else {
                    System.out.print(board[i][j]);
                }
            }
            System.out.println();
            System.out.println("--|---|---");
        }
    }

    private static boolean nextPosition(char[][] tictactoe, char ox) {
        int[][] weights = new int[tictactoe.length][tictactoe.length];

        for (int i = 0; i < tictactoe.length; i++) {
            for (int j = 0; j<  tictactoe[i].length; j++) {
                calculateWeight(tictactoe, weights, i, j, ox);
            }
        }
        for (int i = 0; i < weights.length; i++)
            System.out.println(Arrays.toString(weights[i]));

        boolean result = findMaxWeightAndMark(weights, tictactoe);
        return result;
    }

    private static boolean findMaxWeightAndMark(int[][] weights, char[][]ttt) {
        int maxRow = -1;
        int maxCol = -1;
        int max = -1;
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights[i].length; j++) {
                if (weights[i][j] > max) {
                    max = weights[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        if (max == -1) {
            return false; // 빈 공간이 없다. 
        }
        ttt[maxRow][maxCol] = 'O';
        return true;
    }

    private static void calculateWeight(char[][] ttt, int[][] ws, int row, int col, char ox) {
        /*
            가로, 세로, 대각선 체크
            해당 위치가 빈 공간이 아니면 weight가 -1
            적도 있고 친구도 있으면 weight가 0
            적이 없으면 내패가 많을 수록 weight가 높음.
            적만 있으면 적의 수가 많을 수록 weight가 높음
        */

        int enemies = 0;
        int friends = 0;
        
        if (ttt[row][col] != ' ') {
            ws[row][col] = -1;
            return;
        }
        // 가로 체크
        for (int i = 0; i < ttt.length; i++) {
            if (i == col) continue;
            if (ttt[row][i] != ' ' && ttt[row][i] != ox) { // 적인 경우
                enemies++;
            } else if (ttt[row][i] != ' ' && ttt[row][i] == ox){   // 친구인 경우..
                friends++;
            }
        }
        // 이미 적도 있고 친구도 있으면 별영향가가 없으니 weight를 0로
        if (enemies > 0 && friends > 0) ws[row][col] = 0; // 적도 있고 친구도 있는 경우.
        else if (enemies == 0) { // 적은 없는 경우..
            ws[row][col] = friends + 1; 
        }  else { // 적만 있는 경우...
            ws[row][col] = enemies + 1;
        }

        // 세로 체크
        enemies = 0;
        friends = 0;
        for (int i = 0; i < ttt[0].length; i++) {
            if (i == row) continue;
            if (ttt[i][col] != ' ' && ttt[i][col] != ox) { // 적인 경우
                enemies++;
            } else if (ttt[i][col] != ' ' && ttt[i][col] == ox){ // 친구인 경우
                friends++;
            }
        }

        if (enemies > 0 && friends > 0) { // 적도 있고 친구도 있는 경우.
           // 이미 0 이상의 값을 가지고 있을 테니...
        } else if (enemies == 0) { // 적이 없는 경우
            if (ws[row][col] < friends + 1) { // 이미 있는 값보다 더 큰 값이면 설정
                ws[row][col] = friends + 1;
            }
        } else { // 적만 있는 경우...
            if (ws[row][col] < enemies+1) { // 이미 있는 값보다 더 큰 값이면 설정
                ws[row][col] = enemies+1;
            }
        }
        enemies = 0;
        friends = 0;
        // 대각선 체크
        for (int i = 0; i < ttt.length; i++) {
            if (i == row) continue;
            if(ttt[i][i] != ' ' && ttt[i][i] != ox) { // 적인 경우
                enemies++;
            } else if (ttt[i][i] != ' ' && ttt[i][i] == ox){ // 친구인 경우.
                friends++;
            }
        }
        if (enemies > 0 && friends > 0) { // 적도 있고 친구도 있는 경우.
            // 이미 0 이상의 값을 가지고 있을 테니...
         } else if (enemies == 0) { // 적이 없는 경우
             if (ws[row][col] < friends + 1) { // 이미 있는 값보다 더 큰 값이면 설정
                 ws[row][col] = friends + 1;
             }
         } else { // 적만 있는 경우...
             if (ws[row][col] < enemies+1) { // 이미 있는 값보다 더 큰 값이면 설정
                 ws[row][col] = enemies+1;
             }
         }        

        enemies = 0;
        friends = 0;
        for (int i = ttt.length-1; i >= 0; i--) {
            if (i==row && ttt.length-1-i == col) continue;
        
            if(ttt[i][ttt.length-1-i] != ' ' && ttt[i][ttt.length-1-i] != ox) { // 적인 경우
                enemies++;
            } else if (ttt[i][ttt.length-1-i] != ' ' && ttt[i][ttt.length-1-i] == ox){ // 친구인 경우.
                friends++;        
            }    
        }

        if (enemies > 0 && friends > 0) { // 적도 있고 친구도 있는 경우.
            // 이미 0 이상의 값을 가지고 있을 테니...
         } else if (enemies == 0) { // 적이 없는 경우
             if (ws[row][col] < friends + 1) { // 이미 있는 값보다 더 큰 값이면 설정
                 ws[row][col] = friends + 1;
             }
         } else { // 적만 있는 경우...
             if (ws[row][col] < enemies+1) { // 이미 있는 값보다 더 큰 값이면 설정
                 ws[row][col] = enemies+1;
             }
         }             

    }
    
    private static void testAlaram() {
        int h, m;

        h = input.nextInt();
        m = input.nextInt();

        /*
            m >= 45 이면
                h (m-45)
            그렇지 않으면
                만약 h가 0이면 h = 24
            (h-1) 60-(45-m)
        */

        if (m >= 45) {
            System.out.println(h + " " + (m-45));
        }
        else {
            if (h == 0) h = 24;
            System.out.println((h-1) + " " + (60-(45-m)));
        }
    }

    private static void testFor() {
        int n, x;
        n = input.nextInt();
        x = input.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = input.nextInt();
        }

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] < x) {
                System.out.print(nums[i] + " ");
            }
        }
        System.out.println();
    }

    private static void printStars01() {
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j >= (n-1-i)) 
                    System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void printStars02() {
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j <= i) 
                    System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }   
}
