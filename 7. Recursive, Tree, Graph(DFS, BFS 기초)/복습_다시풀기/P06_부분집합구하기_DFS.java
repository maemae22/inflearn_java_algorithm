package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P06_부분집합구하기_DFS {

    static int[] check; // 0인 것을 출력함
    static int N;

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
                if (check[i]==0) {
                    sb.append(i).append(" ");
                }
            }

            if (sb.length() > 0) {
                System.out.println(sb.toString());
            }
        } else {
            check[L] = 0;
            DFS(L+1);

            check[L] = 1;
            DFS(L+1);
        }
    }
}
