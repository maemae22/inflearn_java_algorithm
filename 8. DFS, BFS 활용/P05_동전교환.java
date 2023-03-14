import java.util.*;
import java.io.*;

/*
다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
각 단위의 동전은 무한정 쓸 수 있다.
입력 : 첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종류가 주어지고,
      그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.각 동전의 종류는 100원을 넘지 않는다.
출력 : 첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.
ex.
3
1 2 5
15
-> 3 ( 출력 설명 : 5 5 5 동전 3개로 거슬러 줄 수 있다. )
 */
public class P05_동전교환 {

    static int N, total, answer;
    static Integer[] coins;

    public static void main(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        coins = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        total = Integer.parseInt(br.readLine());

        // 로직
        Arrays.sort(coins, Collections.reverseOrder()); // coins 내림차순 정렬 (int[] 배열이 아닌 Integer[] 배열이여야 함 !!)

        // 방법1. BFS
//        BFS();

        // 방법2. DFS
        answer = total;
        DFS(0, 0);

        // 출력
        System.out.println(answer);
    }

    public static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<N; i++) {
            q.offer(coins[i]);
        }
        int count = 1;

        while (true) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int tmp = q.poll();
                for (int j=0; j<N; j++) {
                    int next = tmp + coins[j];
                    if (next == total) {
                        answer = count + 1;
                        return;
                    }
                    q.offer(next);
                }
            }
            count++;
        }
    }

    public static void DFS(int count, int sum) {
        if (sum > total || count >= answer) {
            return;
        }

        if (sum == total) {
            answer = Math.min(answer, count);
        } else {
            for (int i=0; i<N; i++) {
                DFS(count+1, sum+coins[i]);
            }
        }
    }

}
