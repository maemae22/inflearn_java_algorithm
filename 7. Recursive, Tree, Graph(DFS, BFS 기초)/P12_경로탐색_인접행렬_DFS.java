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
public class P12_경로탐색_인접행렬_DFS {

    static int[][] arr;
    static int answer;
    static int[] check;

    public static void main(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
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
            for (int i=1; i<=N; i++) {
                if (arr[num][i]==1 && check[i]==0) {
                    check[i] = 1;
                    DFS(i, N);
                    check[i] = 0;
                }
            }
        }
    }

}
