package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P04_피보나치수열_재귀_메모이제이션 {

    static int[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        answer = new int[N+1];

        DFS(N);

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=N; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb.toString());
    }

    public static int DFS(int N) {
        if (N==1 || N==2) {
            return answer[N] = 1;
        } else if (answer[N] != 0) {
            return answer[N];
        } else {
            return answer[N] = DFS(N-2) + DFS(N-1);
        }
    }
}
