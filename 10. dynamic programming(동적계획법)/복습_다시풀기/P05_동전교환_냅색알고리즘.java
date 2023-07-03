package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P05_동전교환_냅색알고리즘 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] coins = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());

        // dy[i] = i원의 금액을 거술러줄 때, 가능한 동전의 최소 개수
        int[] dy = new int[M+1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        Arrays.sort(coins);
        for (int coin : coins) {
            dy[coin] = 1;
        }

        for (int i=1; i<=M; i++) {
            for (int coin : coins) {
                if (i-coin>0 && dy[i-coin]!=Integer.MAX_VALUE) {
                    dy[i] = Math.min(dy[i], dy[i-coin]+1);
                }
            }
        }

        System.out.println(dy[M]);
    }
}
