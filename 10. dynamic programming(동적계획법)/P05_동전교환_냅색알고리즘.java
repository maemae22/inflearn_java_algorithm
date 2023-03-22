import java.util.*;
import java.io.*;

/*
다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
각 단위의 동전은 무한정 쓸 수 있다.
ex.
3
1 2 5
15
->
3 ( 출력설명 : 5 5 5 동전 3개로 거슬러 줄 수 있다. )
 */
public class P05_동전교환_냅색알고리즘 {

    public static void main(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] coins = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        int total = Integer.parseInt(br.readLine());

        // 로직
        Arrays.sort(coins);

        // dy[i] = i 금액을 만드는데 필요한 동전의 최소 개수
        int[] dy = new int[total+1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;

        for (int i=0; i<N; i++) {
            int coin = coins[i];
            for (int j=coin; j<=total; j++) {
                dy[j] = Math.min(dy[j], dy[j-coin]+1);
            }
        }

        // 출력
//        System.out.println(Arrays.toString(dy));
        System.out.println(dy[total]);
    }
}
