import java.util.*;
import java.io.*;

/*
자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성하세요.
출력 : 첫 번째 줄부터 각 줄에 하나씩 부분집합을 아래와 출력예제와 같은 순서로 출력한다. 단 공집합은 출력하지 않습니다.
ex.
3
->
1 2 3
1 2
1 3
1
2 3
2
3
 */
public class P06_부분집합구하기_DFS {

    static int N;
    static int[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        check = new int[N+1];
        DFS(1);
    }

    public static void DFS(int L) {
        if (L == N+1) {
            StringBuilder sb = new StringBuilder();

            for (int i=1; i<=N; i++) {
                if (check[i] == 1) {
                    sb.append(i);
                    sb.append(" ");
                }
            }

            if (sb.length() > 0) {
                System.out.println(sb.toString());
            }
        } else {
            check[L] = 1;
            DFS(L+1);

            check[L] = 0;
            DFS(L+1);
        }
    }

}
