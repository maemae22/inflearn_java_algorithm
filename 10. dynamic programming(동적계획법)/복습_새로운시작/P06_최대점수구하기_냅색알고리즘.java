package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P06_최대점수구하기_냅색알고리즘 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[M+1];
        for (int[] p : arr) {
            for (int i=M; i-p[1]>=0; i--) {
                dp[i] = Math.max(dp[i], dp[i-p[1]]+p[0]);
            }
        }

        System.out.println(dp[M]);
    }
}
