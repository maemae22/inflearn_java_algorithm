import java.util.*;
import java.io.*;

/*
방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요.
입력 : 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연결정보가 주어진다.
출력 : 총 가지수를 출력한다.
ex.
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5
-> 6
설명 :
1 2 3 4 5
1 2 5
1 3 4 2 5
1 3 4 5
1 4 2 5
1 4 5
 */
public class P13_경로탐색_인접리스트_ArrayList {

    static ArrayList<ArrayList<Integer>> list;
    static int answer;
    static int[] check;

    public static void main(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
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

        check = new int[N+1];
        check[1] = 1;

        // 로직 & 출력
        DFS(1, N);
        System.out.println(answer);
    }

    public static void DFS(int num, int N) {
        if (num == N) {
            answer++;
        } else {
//            for (int i=0; i<list.get(num).size(); i++) {
//                int next = list.get(num).get(i);
            for (int next : list.get(num)) {

                if (check[next] == 0) {
                    check[next] = 1;
                    DFS(next, N);
                    check[next] = 0;
                }
            }
        }

    }

}
