import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2579
public class P03_B2579_계단오르기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][3];
        int[] arr = new int[N+1];
        for (int i=1; i<=N; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }

        dp[1][1]=arr[1];
        dp[1][0]=arr[1];
        for (int i=2; i<=N; i++) {
            dp[i][1] = dp[i-2][0]+arr[i];
            dp[i][2] = dp[i-1][1]+arr[i];
            dp[i][0] = Math.max(dp[i][1], dp[i][2]);
        }

        System.out.println(dp[N][0]);
    }

    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        int[] arr = new int[N+1];
        for (int i=1; i<=N; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }

        dp[1]=arr[1];
        if (N!=1) {
            dp[2]=arr[1]+arr[2];
            for (int i=3; i<=N; i++) {
                dp[i] = Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]);
            }
        }

        System.out.println(dp[N]);
    }
}
