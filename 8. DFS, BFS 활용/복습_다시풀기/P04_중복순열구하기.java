package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P04_중복순열구하기 {

    static int N, M;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new int[M];
        DFS(0);
        System.out.println(sb.toString());
    }

    public static void DFS(int level) {
        if (level==M) {
            for (int num : answer) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i=1; i<=N; i++) {
                answer[level] = i;
                DFS(level+1);
            }
        }
    }
}
