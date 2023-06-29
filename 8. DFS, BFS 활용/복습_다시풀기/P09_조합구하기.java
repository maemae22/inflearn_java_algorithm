package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P09_조합구하기 {

    static int[] answer;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new int[M];
        DFS(0, 0);
    }

    public static void DFS(int level, int num) {
        if (level==M) {
            for (int ans : answer) {
                System.out.print(ans+" ");
            }
            System.out.println();
        } else {
            for (int i=num+1; i<=N; i++) {
                answer[level] = i;
                DFS(level+1, i);
            }
        }
    }
}
