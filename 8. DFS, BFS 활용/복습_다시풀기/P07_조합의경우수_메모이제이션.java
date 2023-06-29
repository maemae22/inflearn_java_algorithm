package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P07_조합의경우수_메모이제이션 {

    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];

        DFS(N, M);
        System.out.println(arr[N][M]);
    }

    public static int DFS(int N, int R) {
        if (N==R) {
            return arr[N][R]=1;
        } else if (R==1) {
            return arr[N][R] = N;
        } else if (arr[N][R]!=0) {
            return arr[N][R];
        } else {
            return arr[N][R] = DFS(N-1, R-1) + DFS(N-1, R);
        }
    }
}
