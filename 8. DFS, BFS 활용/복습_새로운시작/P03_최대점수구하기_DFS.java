package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P03_최대점수구하기_DFS {

    static int N;
    static int M;
    static int[][] arr;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][2];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
        }

        DFS(0, 0, 0);
        System.out.println(answer);
    }

    public static void DFS(int index, int timeSum, int scoreSum) {
        if (timeSum>M) {
            return;
        }

        if (index==N) {
            answer = Math.max(answer, scoreSum);
        } else {
            DFS(index+1, timeSum+arr[index][1], scoreSum+arr[index][0]);
            DFS(index+1, timeSum, scoreSum);
        }
    }
}
