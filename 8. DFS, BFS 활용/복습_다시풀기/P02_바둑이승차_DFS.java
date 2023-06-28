package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P02_바둑이승차_DFS {

    static int[] arr;
    static int N;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        DFS(C, 0, 0);
        System.out.println(answer);
    }

    public static void DFS(int limit, int level, int sum) {
        if (limit<sum) {
            return;
        } else if (level==N) {
            answer = Math.max(answer, sum);
        } else {
            DFS(limit, level+1, sum+arr[level]);
            DFS(limit, level+1, sum);
        }
    }
}
