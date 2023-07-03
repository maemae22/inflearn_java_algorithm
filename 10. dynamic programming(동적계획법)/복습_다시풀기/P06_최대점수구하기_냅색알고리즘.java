package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P06_최대점수구하기_냅색알고리즘 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] scores = new int[N];
        int[] times = new int[N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            scores[i] = Integer.parseInt(st.nextToken());
            times[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i] = i 시간 안에 풀 수 있는 최대 점수
        int[] dp = new int[M+1];
        for (int i=0; i<N; i++) {
            for (int j=M; j>=times[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-times[i]]+scores[i]);
            }
        }

        System.out.println(dp[M]);
    }
}
