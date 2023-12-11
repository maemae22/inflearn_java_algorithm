package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P05_동전교환 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] coins = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());

        System.out.println(BFS(coins, M));
    }

    public static int BFS(int[] coins, int total) {
        Queue<Integer> q = new LinkedList<>();
        int[] check = new int[total+1];

        q.offer(0);
        int answer = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int tmp = q.poll();
                for (int plus : coins) {
                    int next = tmp+plus;
                    if (next<=total && check[next]==0) {
                        check[next]=1;
                        q.offer(next);
                    }
                    if (next==total) {
                        return answer+1;
                    }
                }
            }
            answer++;
        }

        return -1;
    }
}
