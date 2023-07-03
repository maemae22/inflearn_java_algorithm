package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P02_돌다리건너기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+2];
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=N+1; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        System.out.println(dp[N+1]);
    }
}
