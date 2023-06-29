package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P05_동전교환 {

    static int N, money;
    static int answer = Integer.MAX_VALUE;
    static Integer[] coins;
    static int[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        coins = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(coins, Collections.reverseOrder());

        money = Integer.parseInt(br.readLine());
        check = new int[money];

//        System.out.println(BFS());
        DFS(0, 0);
        System.out.println(answer);
    }

    public static void DFS(int count, int sum) {
        if (sum>money || count>answer) {
            return;
        }
        if (sum==money) {
            answer = Math.min(answer, count);
        } else {
            for (int i=0; i<N; i++) {
                DFS(count+1, sum+coins[i]);
            }
        }
    }

    public static int BFS() {
        Queue<Integer> q = new LinkedList<>();
        for (int coin : coins) {
            if (coin == money) {
                return 1;
            }
            q.offer(coin);
            check[coin] = 1;
        }

        int answer = 2;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int tmp = q.poll();
                for (int k=0; k<N; k++) {
                    int nsum = tmp + coins[k];
                    if (nsum == money) {
                        return answer;
                    } else if (check[nsum]==0 && nsum<money) {
                        q.offer(nsum);
                        check[nsum] = 1;
                    }
                }
            }
            answer++;
        }
        return -7;
    }
}
