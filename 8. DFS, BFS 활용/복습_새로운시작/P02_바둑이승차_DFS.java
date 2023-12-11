package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P02_바둑이승차_DFS {

    static int N;
    static int C;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        DFS(0, 0);
        System.out.println(answer);
    }

    public static void DFS(int level, int sum) {
        if (sum>C) {
            return;
        }

        if (level==N) {
            answer = Math.max(answer, sum);
        } else {
            DFS(level+1, sum+arr[level]);
            DFS(level+1, sum);
        }
    }
}
