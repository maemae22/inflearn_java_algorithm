import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/4781
public class P01_B4781_사탕가게 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int money = (int) Math.round(Double.parseDouble(st.nextToken())*100);
            if (N==0 && money==0) {
                break;
            }
            int[][] arr = new int[N][2];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = (int) Math.round(Double.parseDouble(st.nextToken())*100);
            }

            long[] dp = new long[money+1];
            for(int[] candy : arr) {
                for(int i=candy[1]; i<=money; i++) {
                    dp[i]=Math.max(dp[i], dp[i-candy[1]]+candy[0]);
                }
            }
            System.out.println(dp[money]);
        }
    }
}
