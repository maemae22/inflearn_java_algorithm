import java.util.*;
import java.io.*;

public class P01_사다리타기 {

    public static char[] solution(int n, int[][] ladder){
        char[] first = new char[n+1];
        for (int i=0; i<=n; i++) {
            first[i] = (char)(64+i);
        }

        char[] result = new char[n+1];
        for (int i=1; i<=n; i++) {
            int now = i;
            for (int j=0; j<ladder.length; j++) {
                for (int k=0; k<ladder[j].length; k++) {
                    if (now==ladder[j][k]) {
                        now++;
                        break;
                    } else if (now==ladder[j][k]+1) {
                        now--;
                        break;
                    }
                }
            }
            result[now] = first[i];
//            System.out.println(now + "/" + first[i]);
        }

        char[] answer = new char[n];
        for (int i=0; i<n; i++) {
            answer[i] = result[i+1];
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
