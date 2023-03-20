import java.util.*;
import java.io.*;

/*
아래의 가중치 방향그래프에서 1번 정점에서 모든 정점으로의 최소 거리비용을 출력하는 프로그램을 작성하세요. (경로가 없으면 Impossible를 출력한다)
입력 : 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연결정보와 거리비용이 주어진다.
출력 : 1번 정점에서 각 정점으로 가는 최소비용을 2번 정점부터 차례대로 출력하세요.
ex.
6 9
1 2 12 // 1번 정점에서 2번정점으로 가는데 12의 비용이 든다.
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5
->
2 : 11
3 : 4
4 : 9
5 : 14
6 : impossible
 */
public class P05_다익스트라알고리즘 {

    public static void main(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

//        int[][] arr = new int[N+1][N+1];
//        for (int i=0; i<M; i++) {
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            int c = Integer.parseInt(st.nextToken());
//            arr[a][b] = c;
//        }

        ArrayList<ArrayList<Pair>> list = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            list.add(new ArrayList<Pair>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Pair(b, c));
        }

        // 로직
        int MAX = Integer.MAX_VALUE;
        int[] answer = new int[N+1];
        int[] check = new int[N+1];
//        Arrays.fill(answer, Integer.MAX_VALUE);
        for (int i=0; i<answer.length; i++) {
            answer[i] = MAX;
        }
        answer[1] = 0;

        PriorityQueue<Pair> pQ = new PriorityQueue<>();
        pQ.offer(new Pair(1, 0));

        while (!pQ.isEmpty()) {
            Pair tmp = pQ.poll();
            int index = tmp.index;
            if (check[index] == 1) {
                continue;
            }
            check[index] = 1;
            for (int j=0; j<list.get(index).size(); j++) {
                Pair pair = list.get(index).get(j);
                if (check[pair.index] == 0) {
                    answer[pair.index] = Math.min(answer[pair.index], tmp.min+pair.min);
                    pQ.add(new Pair(pair.index, answer[pair.index]));
                }
            }
        }

        // 출력
        for (int i=2; i<=N; i++) {
            if (answer[i] == MAX) {
                System.out.println(i + " : impossible");
            } else {
                System.out.println(i + " : " + answer[i]);
            }
        }

    }
}

class Pair implements Comparable<Pair> {
    int index;
    int min;

    public Pair(int index, int min) {
        this.index = index;
        this.min = min;
    }

    @Override
    public int compareTo(Pair o) {
        return this.min - o.min;
    }
}
