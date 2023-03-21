import java.util.*;
import java.io.*;

/*
철수는 학교에 가는데 개울을 만났습니다. 개울은 N개의 돌로 다리를 만들어 놓았습니다.
철수는 돌 다리를 건널 때 한 번에 한 칸 또는 두 칸씩 건너뛰면서 돌다리를 건널 수 있습니다.
철수가 개울을 건너는 방법은 몇 가지일까요?
ex. 7 -> 34
 */
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
