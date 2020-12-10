package codingtest;

import java.util.*;

public class ProgrammersLevelTwoPageOne {
    public static void main(String[] args) {
        // preRequisiteSkills();
        // stockPrices();
        // squaresInOnePiece();
        // distributeSchedule();
        // priorityBasedPrint(); // 너무 복잡해 이 방법으론 안되겠음.
        // priorityBasedPrint2();
        // trucksCrossingBridge();
        // hindex();
        // worldOf124();
        // kakaoFriendsColoringBook();
        triangleSnail();
    }
    private static void triangleSnail() {
        /*
        삼각 달팽이
        문제 설명
        정수 n이 매개변수로 주어집니다. 다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후, 
        첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.

        examples.png

        제한사항
        n은 1 이상 1,000 이하입니다.
        입출력 예
        n	result
        4	[1,2,9,3,10,8,4,5,6,7]
        5	[1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
        6	[1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]
        입출력 예 설명
        입출력 예 #1

        문제 예시와 같습니다.
        입출력 예 #2

        문제 예시와 같습니다.
        입출력 예 #3

        문제 예시와 같습니다.
        */

        /*
            전혀 못 움직일 때까지 다음을 반복
                각 줄의 비워있는 첫번째 셀을 따라 아래로 이동 끝까지 도달하면 
	            비워 있는 마지막 줄을 따라 비워있는 마지막 열까지 이동
	            각 줄의 비워있는 마지막 셀을 따라 위로 이동
        */

        /*
            1  0  0  0 
            2  9  0  0
            3  10 8  0
            4  5  6  7
        */
        int n = 6;
        int[][] triangle = new int[n][n];
        int[] answer = new int[(n+1)*n/2];
        int noMove=0;
        int num=1;
        int row = 0;
        int col = 0;
        while (noMove < 3) {
            noMove = 0;

            System.out.println("row:" + row + ", col:" + col);
            // 밑으로 내려가기 : 시작 row와 column 찾기
            int startRow = row;
            
            for (; row < n && triangle[row][col] == 0; row++)  {
                triangle[row][col] = num++;
            }
            if (row == startRow) noMove++;


            // 옆으로 이동하기
            row -= 1;
            col  += 1;
            int startCol = col;
            for ( ; col < n && triangle[row][col] == 0; col++) {
                triangle[row][col] = num++;
            }
            if (col == startCol) noMove++;
            
            // 위로 이동하기
            row -= 1;
            col -= 2;
            startRow = row;
            for ( ; row >= 0 && col >= 0 && triangle[row][col] == 0; row--, col--) {
                triangle[row][col] = num++;
            }
            if (row == startRow) noMove++;

            row += 2;
            col += 1;
          
        }

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                answer[idx++] = triangle[i][j];
            }
        }
        
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(triangle[i]));
        }
        System.out.println("\n#########################");
        System.out.println(Arrays.toString(answer));

    }


    private static void kakaoFriendsColoringBook() {
        /*
            카카오프렌즈 컬러링북
            문제 설명
            카카오 프렌즈 컬러링북
            출판사의 편집자인 어피치는 네오에게 컬러링북에 들어갈 원화를 그려달라고 부탁하여 여러 장의 그림을 받았다. 
            여러 장의 그림을 난이도 순으로 컬러링북에 넣고 싶었던 어피치는 영역이 많으면 색칠하기가 까다로워 어려워진다는 
            사실을 발견하고 그림의 난이도를 영역의 수로 정의하였다. (영역이란 상하좌우로 연결된 같은 색상의 공간을 의미한다.)

            그림에 몇 개의 영역이 있는지와 가장 큰 영역의 넓이는 얼마인지 계산하는 프로그램을 작성해보자.

            alt text

            위의 그림은 총 12개 영역으로 이루어져 있으며, 가장 넓은 영역은 어피치의 얼굴면으로 넓이는 120이다.

            입력 형식
            입력은 그림의 크기를 나타내는 m과 n, 그리고 그림을 나타내는 m × n 크기의 2차원 배열 picture로 주어진다. 제한조건은 아래와 같다.

            1 <= m, n <= 100
            picture의 원소는 0 이상 2^31 - 1 이하의 임의의 값이다.
            picture의 원소 중 값이 0인 경우는 색칠하지 않는 영역을 뜻한다.
            출력 형식
            리턴 타입은 원소가 두 개인 정수 배열이다. 그림에 몇 개의 영역이 있는지와 가장 큰 영역은 몇 칸으로 이루어져 있는지를 리턴한다.

            예제 입출력
            m	n	picture	answer
            6	4	[[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]]	[4, 5]
            예제에 대한 설명
            예제로 주어진 그림은 총 4개의 영역으로 구성되어 있으며, 왼쪽 위의 영역과 오른쪽의 영역은 모두 1로 구성되어 있지만 상하좌우로 이어져있지 않으므로 다른 영역이다. 
            가장 넓은 영역은 왼쪽 위 1이 차지하는 영역으로 총 5칸이다.
        */

        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0},{1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        // int[][] picture = {{0, 0, 0, 0},{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        // int m = 13;
        // int n = 16;
        // int[][] picture = { {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                            // {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                            // {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                            // {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                            // {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                            // {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0},
                            // {0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0},
                            // {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                            // {0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0},
                            // {0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0},
                            // {0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0},
                            // {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                            // {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},                                                                                                                                                                                                                                                                                                                    
                            //     } ;
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        /*
            클래스 Cell을 만들자  : row, col, group
            같은 값을 가지는 셀의 row, col 인덱스를 저장
            어디에? HashMap에 저장 (cell의 값, 그 값을 가지는 Cell의 List)
            각 List의 원소에 대해 그 원소의 row, col을 조사해 다른 셀(상/하/좌/우)과 연결된 것인지 체크
                - 연결되었다면 그 셀을 그 셀과 연결된 같은 그룹에 저장. <- 그룹은 HashMap으로? (값과 그 갑을 가진 셀의 갯수) 
                 - 연결되지 않았다면 그 셀을 새로운 그룹에 저장.

        */
        HashMap<Integer, ArrayList<Cell>> cellsWithSameValue = new HashMap<>();

        // 셀의 값과, 그 값을 가진 셀들을 값으로 가지는 HashMap 생성.
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = picture[i][j];
                
                if (key == 0) continue; // 0은 색칠하지 않은 영역이니까 skip
                ArrayList<Cell> list = cellsWithSameValue.get(key);
                if (list == null) {
                    list = new ArrayList<>();
                    Cell cell = new Cell(i, j);
                    list.add(cell);
                    cellsWithSameValue.put(key, list);
                } else {
                    Cell cell = new Cell(i, j);
                    list.add(cell);
                }
            }
        }
        
        // 각 영역별 cell의 수를 저장하자.
        HashMap<Integer, Integer> areaCellNum = new HashMap<>();
        // 같은 값을 가진 셀들에 대해, 영역이 몇개인지, 그 중 가장 넓은 영역의 셀 수는 몇개인지 체크
        Iterator<Integer> iter = cellsWithSameValue.keySet().iterator();
        while(iter.hasNext()) { // 같은 값을 가진 cell들의 리스트에 대해
            int key = iter.next();
            ArrayList<Cell> list = cellsWithSameValue.get(key);
            // System.out.println("key:" + key + " : " + list + "\n\n");
            for (int i = 0; i < list.size(); i++) {
                Cell cell = list.get(i);
                // 이 cell과 상/하/좌/우 중에 하나라도 연결된 cell이 있는지 찾아본다. 있다면 같은 그룹으로 묶는다. 
                boolean adjacentCellFound = false;
                ArrayList<Cell> visited = new ArrayList<>();
                for (int j = 0; j < list.size(); j++) {
                    if (i == j) continue;
                    Cell aCell = list.get(j);
                    boolean isAdjacent = checkIfAdjacent(cell, aCell);

                    if (isAdjacent) {
                        if (aCell.group == 0) { // group is not asigned yet, then 
                            
                            int anum = findAreaNum(aCell, list, picture, visited); 

                            if (anum == 0) {
                                numberOfArea++;
                                aCell.group = numberOfArea;
                            } else {
                                aCell.group = anum;
                            }
                 
                        }
                        cell.group = aCell.group;// 같은 영역으로 표시.

                        System.out.println(cell);
                        System.out.println(visited);

                        Integer cnt = areaCellNum.get(cell.group);
                        if (cnt == null) { // 그 area의 cell 수를 증가시킴.
                            areaCellNum.put(cell.group, 1);
                        } else {
                            areaCellNum.put(cell.group, cnt+1);
                        }
                        adjacentCellFound = true;
                        break;
                    }
                }
                if (adjacentCellFound == false) {
                    numberOfArea++;
                    cell.group = numberOfArea; // 새로운 영역으로 표시. 
                    areaCellNum.put(cell.group, 1);
                }
                // System.out.println("cell:" + cell + ", " + adjacentCellFound);


            }
        }
        
        // 가장 큰 영역을 찾는다. 
        iter = areaCellNum.keySet().iterator();
        int sum = 0;
        while(iter.hasNext()) {
            int key = iter.next();
            int cnt = areaCellNum.get(key);
            // System.out.println("key:" + key + ", cnt:" + cnt);
            sum += cnt;
            if ( cnt > maxSizeOfOneArea) {
                maxSizeOfOneArea = cnt;
            }
        }
        System.out.println("sum:" + sum);
        // System.out.println(areaCellNum.size());
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        System.out.println(Arrays.toString(answer));
        iter = cellsWithSameValue.keySet().iterator();
        while(iter.hasNext()) { // 같은 값을 가진 cell들의 리스트에 대해
            int key = iter.next();
            ArrayList<Cell> list = cellsWithSameValue.get(key);
            System.out.println("key:" + key + " : " + list + "\n\n");
        }    
    }

    private static int findAreaNum(Cell aCell, ArrayList<Cell> list, int[][]picture, ArrayList<Cell> visited) {
        if (aCell.group != 0) return aCell.group;   
        // 위쪽으로 인접셀을 찾기 
        // System.out.println("row:" + aCell.row + ", col:" + aCell.col);
        if (aCell.row > 0) {
            if (picture[aCell.row][aCell.col] == picture[aCell.row-1][aCell.col]) {
                Cell bCell = findCell(aCell.row-1, aCell.col, list);
                
                if (bCell.group != 0) return bCell.group;
                if (visited.indexOf(bCell) == -1) {
                    visited.add(bCell);
                    int num = findAreaNum(bCell, list, picture, visited);
                    if (num > 0) return num;
                }    
            } 
        }    
  
        // 위쪽 인접셀이 없으면 왼쪽으로 인접셀 찾기
        if (aCell.col > 0) {
            if (picture[aCell.row][aCell.col] == picture[aCell.row][aCell.col-1]) {
                Cell bCell = findCell(aCell.row, aCell.col-1, list);
                if (bCell.group != 0) return bCell.group;
                if (visited.indexOf(bCell) == -1) {
                    visited.add(bCell);
                    int num = findAreaNum(bCell, list, picture, visited);
                    if (num > 0) return num;
                } 
                // return findAreaNum(bCell, list, picture);
            } 
        }
        // 왼쪽 인접셀이 없으면 아래쪽으로 인접셀 찾기
        if (aCell.row < picture.length-1) {
            if (picture[aCell.row][aCell.col] == picture[aCell.row+1][aCell.col]) {
                Cell bCell = findCell(aCell.row+1, aCell.col, list);
                if (bCell.group != 0) return bCell.group;
                if (visited.indexOf(bCell) == -1) {
                    visited.add(bCell);
                    int num = findAreaNum(bCell, list, picture, visited);
                    if (num > 0) return num;
                } 
                // return findAreaNum(bCell, list, picture);
            } 
        }
        // 아래쪽 인접셀이 없으면 오른쪽 인접셀 찾기
        if (aCell.col < picture[aCell.row].length-1) {
            if (picture[aCell.row][aCell.col] == picture[aCell.row][aCell.col+1]) {
                Cell bCell = findCell(aCell.row, aCell.col+1, list);
                if (bCell.group != 0) return bCell.group;
                if (visited.indexOf(bCell) == -1) {
                    visited.add(bCell);
                    int num = findAreaNum(bCell, list, picture, visited);
                    if (num > 0) return num;
                } 
                // return findAreaNum(bCell, list, picture);
            } 
        }
        return 0;
    }

    private static Cell findCell(int row, int col, ArrayList<Cell> list) {
        for (int i = 0; i < list.size(); i++) {
            Cell cell = list.get(i);
            if (cell.row == row && cell.col==col) return cell;
        }

        return null;
    }

    private static  boolean checkIfAdjacent(Cell cell, Cell aCell) {
        boolean adjacent = false;
        int tmpRow = aCell.row;
        int tmpCol = aCell.col;

        if (tmpCol == cell.col && tmpRow == cell.row - 1) { // 위의 셀인지 체크
            adjacent = true;
        } else if (tmpCol == cell.col - 1 && tmpRow == cell.row) { // 왼쪽 셀인지 체크
            adjacent = true;
        } else if (tmpCol == cell.col && tmpRow == cell.row+1) { // 아래 셀인지 체크
            adjacent = true;
        } else if (tmpCol == cell.col + 1 && tmpRow == cell.row) { // 오른쪽 셀인지 체크 
            adjacent = true;
        }

        return adjacent;
    }
    public static class Cell {
        public int row;
        public int col;
        public int group;
        public Cell(int row, int col, int group) {
            this.row = row;
            this.col = col;
            this.group = group;
        }
        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public boolean isSameColor(Cell cell, int[][] picture) {
          
            if (picture[row][col] == picture[cell.row][cell.col])
                return true;
        
            return false;
        }

        public String toString() {
            return "[row:" + row + ", col: " + col + ", group:" + group+"]";
        }
    }

    private static void worldOf124() {
        /*
            124 나라의 숫자
            문제 설명
            124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.

            124 나라에는 자연수만 존재합니다.
            124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
            예를 들어서 124 나라에서 사용하는 숫자는 다음과 같이 변환됩니다.

            10진법	124 나라	10진법	124 나라
            1	        1	    6	    14
            2	        2	    7	    21
            3	        4	    8	    22
            4	        11	    9	    24
            5	        12	    10	    41
            자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.

            제한사항
            n은 500,000,000이하의 자연수 입니다.
            입출력 예
            n	result
            1	1
            2	2
            3	4
            4	11
        */

        // 1. 3진수로 변환  1, 2, 3 -> 1, 2, 4
        // 2.    1   -> 1                           102 ->  42  (3*3 + 2)
            //   2   -> 2                           110 -> 44 (3*3 + 3)
            //   3   -> 4                           111 -> 111  (3²*1 + 3*1 + 1)  
            //   11  -> 11  (3*1+1)                 112 -> 112  (3²*1 + 3*1 + 2)
            //   12  -> 12  (3*1+2)                 120 -> 114  (3²*1 + 3*1 + 3)
            //   20  -> 14  (3*1+3)                 121 -> 121  (3²*1 + 3*2 + 1)
            //   21  -> 21  (3*2+1)
            //   22  -> 22  (3*2+2)
            //   100 -> 24  (3*2+3) 
            //   101 -> 41  (3*3+1)
            
            /* 
                ==> 3진수 표현에서 0이면 3ⁱ * 3이라 하고 위에서 1빌려온다. 
                3진수로 101이면  최상위 1은 빌려줘서 0 -> 3¹*3 + 3⁰*1 그래서 41

                20001이면 
                   2             0                  0              0                0            1
                   1(빌림X)       2(빌림O)            2(빌림O)        2(빌림O)          4(빌림X)      1 (빌림X)
                */ 
            int n = 15;
            String answer = "";
            StringBuilder sb = new StringBuilder();
            
            while (n > 0) {
                int digit = n % 3;
                // temp = digit + temp;
                sb.append(digit);
                n = n/3;
            }
            String temp = sb.toString();
            // System.out.println(temp);
            
            sb = new StringBuilder();
            boolean borrow = false; // 위의 자리에서 빌려온 값 
            for (int i = 0; i < temp.length(); i++) {
            
                char c = temp.charAt(i);
                // int digit = Integer.parseInt(c+"");

                if (borrow == false) { // 빌려준 것이 없을 때 
                    if (c != '0')
                        sb.append(c);
                        // answer = c + answer;
                    else {
                        sb.append("4");
                        // answer = "4" + answer;
                        borrow=true;  // 위에서 빌려왔음을 표시. 
                    }
                } else { // 빌려준 것이 있을 때 
                    if (c == '0') c = '2'; // 위에서 빌려와야 하니 borrow는 여전히 1
                    else {
                        c = (char)(c - 1);
                        borrow = false; // 빌려준 것은 일단 처리 했음..
                    }
                    if (c > '0') { // 빌려준 것을 처리하고 난 후의 값
                        sb.append(c);
                        //  answer = c + answer;
                    } else { // 0이면 위에서 빌려오고 4로...
                        if (i < temp.length()-1) { // 빌려올 때가 있으면..
                            sb.append("4");
                            // answer = "4"+answer;
                            borrow = true;
                        }
                            
                    }    
                }
            }
            
            answer = sb.reverse().toString();
            System.out.println("\n"+answer);

    }   


    private static void hindex() {
        /*
            H-Index
            문제 설명
            H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 
            어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.

            어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.

            어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.

            제한사항
            과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
            논문별 인용 횟수는 0회 이상 10,000회 이하입니다.
            입출력 예
            citations	return
            [3, 0, 6, 1, 5]	3
            입출력 예 설명
            이 과학자가 발표한 논문의 수는 5편이고, 그중 3편의 논문은 3회 이상 인용되었습니다. 그리고 나머지 2편의 논문은 3회 이하 인용되었기 때문에 이 과학자의 H-Index는 3입니다.     
        */

        /*  h-index=0
            i를 0부터 시작해 주어진 배열의 가장 큰 값만큼 반복한다.
                i보다 큰 값을 가진 원소의 갯수 ≥ 그 이하인 원소의 갯수이면 
                h-index는 i
            
            모든 루프를 다 돌았을 때 h-index가 답
        */

        int[] citations = {3, 0, 6, 1, 5};
        // int[] citations = {0, 0, 0, 1, 5};
        int answer = 0;

        int max = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] > max) max = citations[i];
        }
        System.out.println("max:" + max);
        for (int i = 0; i <= max; i++) {
            int count = 0;
            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= i) {
                    count++;
                }
            }
            if (count >= i && count >= (citations.length - count)) answer = i;
            System.out.println("i:" + i + ", count:" + count + ", answer:" + answer);
        }
        System.out.println(answer);
    }

    private static void trucksCrossingBridge() {
        /*
        다리를 지나는 트럭
        문제 설명
        트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
        ※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.

        예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.

        경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
        0	[]	[]	[7,4,5,6]
        1~2	[]	[7]	[4,5,6]
        3	[7]	[4]	[5,6]
        4	[7]	[4,5]	[6]
        5	[7,4]	[5]	[6]
        6~7	[7,4,5]	[6]	[]
        8	[7,4,5,6]	[]	[]
        따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.

        solution 함수의 매개변수로 다리 길이 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭별 무게 truck_weights가 주어집니다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.

        제한 조건
        bridge_length는 1 이상 10,000 이하입니다.
        weight는 1 이상 10,000 이하입니다.
        truck_weights의 길이는 1 이상 10,000 이하입니다.
        모든 트럭의 무게는 1 이상 weight 이하입니다.
        입출력 예
        bridge_length	weight	truck_weights	                    return
                2	    10	    [7,4,5,6]	                         8
                100	    100	    [10]	                            101
                100	    100	    [10,10,10,10,10,10,10,10,10,10]     110
        */
        // int bridge_length = 2;
        // int weight = 10;
        // int[] truck_weights = {7, 4, 5, 6};

        // int bridge_length = 100;
        // int weight = 100;
        // int[] truck_weights = {10};

        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};        

        int answer = 0;

        int[] trucksInBridge = new int[bridge_length];

        /* 
            int elpasedTime = 0;
            int idx = 0;
            while(true) {
                // trucksInBridge도 empty이고 truck_weights도 empty 이면 break;
                // trucksInBridge의 트럭들을 한 칸 이동시킨다. 
                // idx 위치의 트럭을 trucksInBridge에 넣을 수 있으면 넣고 idx++. 
                // elapsedTime++;

            }
        */

        int elapsedTime = 0;
        int idx = 0; 
        while(true) {

            if(isBridgeEmpty(trucksInBridge) == true && idx > truck_weights.length-1) break;

            moveForward(trucksInBridge);

            int totalWeight = getTotalWeight(trucksInBridge);
            System.out.println("totalWeight:"+totalWeight);
            // System.out.println("truck_weights[idx]:"+truck_weights[idx]);
            if (idx < truck_weights.length && (totalWeight + truck_weights[idx]) <= weight) {
                trucksInBridge[0] = truck_weights[idx++];
            }

            elapsedTime++;
            System.out.println(Arrays.toString(trucksInBridge));
            System.out.println("idx:" + idx);
            System.out.println();
        }
        answer = elapsedTime;

        System.out.println(answer);
    }

    private static int getTotalWeight(int[] bridge) {
        int sum = 0;
        for (int i = 0; i < bridge.length; i++)
            sum+= bridge[i];

        return sum;
    }

    private static void moveForward(int[] bridge) {
        bridge[bridge.length-1] = 0;
        for (int i = bridge.length-2 ; i >= 0; i--) {
            if (bridge[i] > 0) {
                bridge[i+1] = bridge[i];
                bridge[i] = 0;
            }    
        }
    }

    private static boolean isBridgeEmpty(int[] bridge) {
        for (int i = 0; i < bridge.length; i++) {
            if (bridge[i] > 0) return false;
        }
        return true;
    }

    private static void priorityBasedPrint2() {
        /* 
            int[] printOrders = new int[priorities.length];
            cnt = 0;
            현재의 max 인덱스 idx를 구하고
            그 앞에 있는 것들은 
            pop(0) & append
        */

        // int[] priorities = {2, 1, 3, 2};
        // int location = 2;



        // int[] priorities = {1, 1, 9, 1, 1, 1};
        // int location = 0;

        int[] priorities = {1, 2, 1, 2, 3, 4, 5, 7, 8, 1, 3, 7};
        int location =1 ;

        int answer = 0;

        ProgrammersLevelTwoPageOne ptp = new ProgrammersLevelTwoPageOne();

        LinkedList<PriorityPosition> list = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            PriorityPosition pp = ptp.new PriorityPosition(priorities[i], i);
            list.add(pp);
        }

        int idx = 0;
        while(idx < priorities.length) {
            int maxIdx = max(list, idx);
            System.out.println("maxIdx:"+maxIdx + ", idx:" + idx);
            for (int i = idx; i < maxIdx;i++) {
                list.addLast(list.remove(idx));
            }
            idx++;    
        }

        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).position == location) {
                answer = i+1;
                break;
            }
        }
        System.out.println(answer);

    }

    private static int max(LinkedList<PriorityPosition> list, int startIdx) {
        int maxIdx = startIdx;
        for (int i = startIdx+1; i < list.size(); i++) {
            if (list.get(maxIdx).priority < list.get(i).priority) {
                maxIdx = i; 
            }
        }

        return maxIdx;
    }

    private static void priorityBasedPrint() {
        /*
            프린터
            문제 설명
            일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다. 
            이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다. 
            이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.

            1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
            2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
            3. 그렇지 않으면 J를 인쇄합니다.
            예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.

            내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.

            현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 내가 인쇄를 요청한 문서가 현재 대기목록의 
            어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때, 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 
            solution 함수를 작성해주세요.

            제한사항
            현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
            인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
            location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 
            두 번째에 있으면 1로 표현합니다.
            입출력 예
            priorities	        location	return
            [2, 1, 3, 2]	        2	    1
            [1, 1, 9, 1, 1, 1]	    0	    5
            입출력 예 설명
            예제 #1

            문제에 나온 예와 같습니다.

            예제 #2

            6개의 문서(A, B, C, D, E, F)가 인쇄 대기목록에 있고 중요도가 1 1 9 1 1 1 이므로 C D E F A B 순으로 인쇄합니다.
        */
        // int[] priorities = {2, 1, 3, 2};
        // int location = 2;
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        int answer = 0;
        ProgrammersLevelTwoPageOne ptp = new ProgrammersLevelTwoPageOne();
        ArrayList<PriorityPosition> list = new ArrayList<>();
        // priority와 position을 멤버변수로 가지는 객체를 만들자.
        for (int i = 0; i < priorities.length; i++) {
            PriorityPosition pp = ptp.new PriorityPosition(priorities[i], i);
            list.add(pp);
        }

        // stable sort인 삽입정렬로 정렬
        for (int i = 1; i < list.size(); i++) {
            PriorityPosition pp = list.get(i);
            int j = i-1;
            for (; j >= 0; j--) {
                if (pp.priority > list.get(j).priority) {
                    list.set(j+1, list.get(j));
                } else break;
            }
            // System.out.println("i:"+i + ", j+1 : " + (j+1));
            list.set(j+1, pp);
        }
        
        System.out.println("list.size():"+ list.size());

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        System.out.println("----------------------------------");
       
        // 정렬된 값보다 원래 앞에 있었던 것들은 같은 값 중에 가장 마지막에 위치시닌다.
        // for (int i = 0; i < list.size(); i++) {
        //     PriorityPosition pp = list.get(i);
        //     for (int j = i+1; j < list.size(); j++) {
        //         if (list.get(j).position < pp.position) {
                    
        //         }
        //     }
        // }

                
        // location 변수에 저장된 값과 같은 position을 찾아 그 순서를 반환 
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            if (list.get(i).position == location) {

                answer = (i+1);
                break;
            }    
        }

        System.out.println(answer);
    }


    class PriorityPosition {
        int priority ;
        int position;
        public PriorityPosition(int priority, int position) {
            this.priority = priority;
            this.position = position;
        }
        public String toString() {
            return "[priority:" + priority+", position:"+position+"]";
        }
    }

    private static void distributeSchedule() {
        /*
            기능개발
            문제 설명
            프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.

            또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 
            이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.

            먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 
            각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.

            제한 사항
            작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
            작업 진도는 100 미만의 자연수입니다.
            작업 속도는 100 이하의 자연수입니다.
            배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 
            예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
            입출력 예
            progresses	                speeds	                     return
            [93, 30, 55]	                [1, 30, 5]	            [2, 1]
            [95, 90, 99, 99, 80, 99]       	[1, 1, 1, 1, 1, 1]	    [1, 3, 2]
            입출력 예 설명
            입출력 예 #1
            첫 번째 기능은 93% 완료되어 있고 하루에 1%씩 작업이 가능하므로 7일간 작업 후 배포가 가능합니다.
            두 번째 기능은 30%가 완료되어 있고 하루에 30%씩 작업이 가능하므로 3일간 작업 후 배포가 가능합니다. 
            하지만 이전 첫 번째 기능이 아직 완성된 상태가 아니기 때문에 첫 번째 기능이 배포되는 7일째 배포됩니다.
            세 번째 기능은 55%가 완료되어 있고 하루에 5%씩 작업이 가능하므로 9일간 작업 후 배포가 가능합니다.

            따라서 7일째에 2개의 기능, 9일째에 1개의 기능이 배포됩니다.

            입출력 예 #2
            모든 기능이 하루에 1%씩 작업이 가능하므로, 작업이 끝나기까지 남은 일수는 각각 5일, 10일, 1일, 1일, 20일, 1일입니다. 
            어떤 기능이 먼저 완성되었더라도 앞에 있는 모든 기능이 완성되지 않으면 배포가 불가능합니다.

            따라서 5일째에 1개의 기능, 10일째에 3개의 기능, 20일째에 2개의 기능이 배포됩니다.
        */

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        // int[] progresses = {95, 90, 99, 99, 80, 99};
        // int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] daysToComplete = new int[progresses.length];

        // 각 진척도별 진도에 따라, 완료까지 소요 기간을 계산한다.
        for (int i = 0; i < progresses.length; i++) {
            int days = 0;
            while ((progresses[i] + days*speeds[i]) < 100) {
                days++;
            }
            daysToComplete[i] = days;
        }

        System.out.println(Arrays.toString(daysToComplete));
        // 7, 3, 9
        // 5, 10, 1, 1, 20, 1
        /* 
           1. 각 소요 일에 대해 그 뒤에 오는 일수 중 작거나 같은 일수가 몇개인지 체크.. 
           2. 작거나 같은 일수 마지막 그 다음 일 수부터 다시 1번 반복.
        */

        ArrayList<Integer> ansList = new ArrayList<>();
        
        for (int i = 0; i < daysToComplete.length; ) {
            int cnt = 1;
            int days = daysToComplete[i];
            for (int j = i+1; j < daysToComplete.length; j++) {
                if (days >= daysToComplete[j]) cnt++;
                else break;
            }
            ansList.add(cnt);
            i = i + cnt;
        }
       int[] answer = new int[ansList.size()];
       int i  = 0;
       for (int n : ansList) answer[i++] = n;
        
        System.out.println(ansList);
    }



    private static void squaresInOnePiece() {
        /*
            멀쩡한 사각형
            문제 설명
            가로 길이가 Wcm, 세로 길이가 Hcm인 직사각형 종이가 있습니다. 종이에는 가로, 세로 방향과 평행하게 격자 형태로 선이 그어져 있으며, 
            모든 격자칸은 1cm x 1cm 크기입니다. 이 종이를 격자 선을 따라 1cm × 1cm의 정사각형으로 잘라 사용할 예정이었는데, 
            누군가가 이 종이를 대각선 꼭지점 2개를 잇는 방향으로 잘라 놓았습니다. 
            그러므로 현재 직사각형 종이는 크기가 같은 직각삼각형 2개로 나누어진 상태입니다. 
            새로운 종이를 구할 수 없는 상태이기 때문에, 이 종이에서 원래 종이의 가로, 세로 방향과 평행하게 1cm × 1cm로 잘라 사용할 수 있는 만큼만 
            사용하기로 하였습니다.
            가로의 길이 W와 세로의 길이 H가 주어질 때, 사용할 수 있는 정사각형의 개수를 구하는 solution 함수를 완성해 주세요.

            제한사항
            W, H : 1억 이하의 자연수
            입출력 예
            W	H	result
            8	12	80
            입출력 예 설명
            입출력 예 #1
            가로가 8, 세로가 12인 직사각형을 대각선 방향으로 자르면 총 16개 정사각형을 사용할 수 없게 됩니다. 
            원래 직사각형에서는 96개의 정사각형을 만들 수 있었으므로, 96 - 16 = 80 을 반환합니다.
        */
        /* 
          Height : 12, Width: 8 => 3/2
       
          i를 0에서 width-1까지 ceil((i+1)*(h/w)-i*(h/w))만큼을 합한 만큼 버려짐.
        */

        // test case 통과율 50%
        long answer = 0;
        int w = 8;
        int h = 12;
        // double height = h;
        // double width = w;
        // long discardCnt = 0;
        // double i = 0.0;
        // double hwRatio = height/width;
        // while (i+1 <= width) {

        //     double val2 = (i+1)*hwRatio ;
        //     double val1 = i*hwRatio;
        //     if (val2 > height) val2 = height;
            
        //     discardCnt += Math.ceil(val2 - val1);
            
        //     i += 1;
        // }
        // System.out.println("discardCnt:" + discardCnt);

        // answer = (long)w*(long)h - discardCnt;

        // System.out.println("answer:" + answer);


        // 다른 풀이법
        /*
         깨진 사각형의 개수 = 가로 + 세로 - (가로 세로의 최대공약수)
         이란다...
        */

        long width = w;
        long height = h;

        long whole = width*height;
        long broken = width + height - gcd(w, h);
        answer = whole - broken;

        System.out.println(answer);

    }

    private static long gcd(long w, long h) {
        if (w < h) {
            long tmp = w;
            w = h;
            h = tmp;
        }
        if (h == 0) return w;
        return gcd(h, w%h);
    }

    private static void stockPrices() {
        /*
            주식가격
            문제 설명
            초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.

            제한사항
            prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
            prices의 길이는 2 이상 100,000 이하입니다.
            입출력 예
            prices	return
            [1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
            입출력 예 설명
            1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
            2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
            3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
            4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
            5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.
            ※ 공지 - 2019년 2월 28일 지문이 리뉴얼되었습니다.
        */
        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = new int[prices.length];

        /*
            prices의 각 원소에 대해 (prices[i])
                sec = 0
                prices의 그 원소 다음 원소들 각각과 값을 비교한다. (prices[j]) 
                    sec++;
                    만약 prices[i] > prices[j] break;
            
                answer[i] = sec;
        */
        for (int i = 0; i < prices.length-1; i++) {
            int sec = 0;
            for (int j = i+1; j < prices.length; j++) {
                sec++;
                if (prices[i] > prices[j]) break;
            }
            answer[i] = sec;
        }
        answer[prices.length-1] = 0;
        
        for (int i=0; i < prices.length; i++)
            System.out.print(answer[i] + " ");
    }

    private static void preRequisiteSkills() {
        /*

        스킬트리
        문제 설명
        선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.

        예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 
        라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.

        위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다. 
        따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만, 
        썬더 → 스파크나 라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.

        선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때, 
        능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.

        제한 조건
        스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
        스킬 순서와 스킬트리는 문자열로 표기합니다.
        예를 들어, C → B → D 라면 CBD로 표기합니다
        선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
        skill_trees는 길이 1 이상 20 이하인 배열입니다.
        skill_trees의 원소는 스킬을 나타내는 문자열입니다.
        skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.
        입출력 예
        skill	skill_trees	return
        "CBD"	["BACDE", "CBADF", "AECB", "BDA"]	2
        입출력 예 설명
        BACDE: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트립니다.
        CBADF: 가능한 스킬트리입니다.
        AECB: 가능한 스킬트리입니다.
        BDA: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트리입니다.

        */

        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        
        /*
            스킬 트리의 각 문자열에 대해
                preMatchSkillNum = -1
                isPossibleSkillTree = true;
                각 문자열의 각 문자에 대해 대응되는 문자열이 skill에 있는지 체크 
                    만약 없으면 OK
                    있으면 skill에서 대응되는 문자의 인덱스가 preMatchSkillNum+1이면 preMatchSkillNum = 그 인덱스 
                    그렇지 않으면 불가능한 스킬트리. isPossibleSkillTree = false; break; 
                
        */
        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) { // 스킬 트리의 각 문자열에 대해
            int preMatchSkillNum = -1;
            boolean isPossibleSkillTree = true;
            for (int j = 0; j < skill_trees[i].length(); j++) { // 그 문자열의 각 문자에 대해
                for (int k = 0; k < skill.length(); k++) { // skill의 문자와 매치되는 것이 있는지 체크
                    if (skill_trees[i].charAt(j) == skill.charAt(k)) {
                        if (k == preMatchSkillNum+1) {
                            preMatchSkillNum = k;
                        } else {
                            isPossibleSkillTree = false;
                            break;        
                        }
                    }
                }
            }
            if (isPossibleSkillTree) answer++;
        }
        System.out.println(answer);
    }
}
