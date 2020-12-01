package codingtest;

public class ProgrammersLevelTwoPageOne {
    public static void main(String[] args) {
        // preRequisiteSkills();
        // stockPrices();
        squaresInOnePiece();
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
