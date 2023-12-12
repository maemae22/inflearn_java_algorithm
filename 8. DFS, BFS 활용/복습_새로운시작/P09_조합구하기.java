package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P09_조합구하기 {

    static int[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        answer = new int[M];
        DFS(0, 1, N, M);
    }

    public static void DFS(int index, int minNum, int N, int M) {
        if (index==M) {
            for (int tmp : answer) {
                System.out.print(tmp+" ");
            }
            System.out.println();
        } else {
            for (int i=minNum; i<=N; i++) {
                answer[index]=i;
                DFS(index+1, i+1, N, M);
            }
        }
    }
}
