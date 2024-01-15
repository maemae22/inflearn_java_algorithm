import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2073
public class P02_B2073_수도배관공사 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] dp = new int[D+1];
        for (int i=0; i<P; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            for (int k=D; L<k; k--) {
                if (dp[k-L]!=0) {
                    dp[k]=Math.max(dp[k], Math.min(dp[k-L], C));
                }
            }
            dp[L] = Math.max(dp[L], C);
        }

        System.out.println(dp[D]);
    }
}
