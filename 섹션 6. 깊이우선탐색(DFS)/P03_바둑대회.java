import java.util.*;

public class P03_바둑대회 {

    static int N;
    static int answer;
    public int solution(int[][] cans){
        answer = Integer.MAX_VALUE;
        N = cans.length;

        DFS(cans, new int[N], 0, 0, 0, 0);
        return answer;
    }

    public void DFS(int[][] cans, int[] check, int whiteSum, int blackSum, int pick, int count) {
        if (count==N) {
            answer = Math.min(answer, Math.abs(whiteSum-blackSum));
        } else {
            for (int i=0; i<cans.length; i++) {
                if (check[i]==0) {
                    check[i]=1;
                    if (pick<N/2) {
                        DFS(cans, check, whiteSum+cans[i][0], blackSum, pick+1, count+1);
                    } else {
                        DFS(cans, check, whiteSum, blackSum+cans[i][1], pick, count+1);
                    }
                    check[i]=0;
                }
            }
        }
    }

    public static void main(String[] args){
        P03_바둑대회 T = new P03_바둑대회();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}}));
    }
}
