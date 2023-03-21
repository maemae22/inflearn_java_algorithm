import java.util.*;
import java.io.*;

/*
철수는 계단을 오를 때 한 번에 한 계단 또는 두 계단씩 올라간다. 만약 총 4계단을 오른다면 그 방법의 수는
1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2 로 5가지이다.
그렇다면 총 N계단일 때 철수가 올라갈 수 있는 방법의 수는 몇 가지인가?
ex. 7 -> 21
 */
public class P01_계단오르기 {

    static int answer;
    static int N;

    // 방법1. DFS 풀이법 사용
    public static void main1(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        DFS(0);
        System.out.println(answer);
    }

    public static void DFS(int sum) {
        if (sum > N) {
            return;
        }

        if (sum == N) {
            answer++;
        } else {
            DFS(sum+1);
            DFS(sum+2);
        }
    }

    // 방법2. 동적계획법 (DP) 풀이법 사용
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=N; i++) {
            // i번째 계단으로 가는 방법은 = i-2번째 계단에서 두 계단 올라가는거 + i-1번째 계단에서 한 계단 올라가는 것임
            dp[i] = dp[i-2] + dp[i-1];
        }

        System.out.println(dp[N]);
    }
}
