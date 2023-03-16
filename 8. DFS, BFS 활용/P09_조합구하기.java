import java.util.*;
import java.io.*;

/*
1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 M개를 뽑는 방법의 수를 출력하는 프로그램을 작성하세요.
출력순서는 사전순으로 오름차순으로 출력합니다.
ex.
4 2
->
1 2
1 3
1 4
2 3
2 4
3 4
 */
public class P09_조합구하기 {

    static int N, M;
    static int[] answer;
    static int[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new int[M];
        check = new int[N+1];
        DFS(0, 1);
    }

    public static void DFS(int index, int min) {
        if (index == M) {
            for (int num : answer) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            for (int i=min; i<=N; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    answer[index] = i;
                    DFS(index+1, i+1);
                    check[i] = 0;
                }
            }
        }
    }
}
