import java.util.*;
import java.io.*;

/*
다음 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선수를 출력하세요.
입력 : 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연결정보가 주어진다.
출력 : 1번 정점에서 각 정점으로 가는 최소 간선수를 2번 정점부터 차례대로 출력하세요.
ex.
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5
->
2 : 3
3 : 1
4 : 1
5 : 2
6 : 2
 */
public class P14_그래프최단거리_BFS {

    static ArrayList<ArrayList<Integer>> list;
    static int[] answer;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<=N; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
        }

        answer = new int[N+1];

//        BFS(1);
        BFSBFS(1);

        for (int i=2; i<=N; i++) {
            System.out.println(i + " : " + answer[i]);
        }
    }

    public static void BFS(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        int level = 0;

        while (hasMystery(answer)) {
            int size = q.size();
            level++;
            for (int i=0; i<size; i++) {
                int nowNum = q.poll();
                for (int next : list.get(nowNum)) {
                    if (answer[next] == 0) {
                        answer[next] = level;
                        if (!q.contains(next)) {
                            q.offer(next);
                        }
                    }
                }
            }
        }
    }

    public static boolean hasMystery(int[] answer) {
        for (int i=2; i<=N; i++) {
            if (answer[i] == 0) {
                return true;
            }
        }
        return false;
    }

    public static void BFSBFS(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(num);
        answer[num] = 0;

        while (!q.isEmpty()) {
            int nowNum = q.poll();
            for (int next : list.get(nowNum)) {
                if (answer[next] == 0) {
                    answer[next] = answer[nowNum] + 1;
                    q.offer(next);
                }
            }
        }
    }

}
