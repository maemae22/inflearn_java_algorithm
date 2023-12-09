package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P12_경로탐색_인접행렬_DFS {

    static int answer = 0;
    static int N;
    static int[][] arr;
    static int[] check;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        check = new int[N+1];
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
        }

        check[1]=1;
        DFS(1);
        System.out.println(answer);
    }

    public static void DFS(int start) {
        if (start==N) {
            answer++;
        } else {
            for (int i=1; i<=N; i++) {
                if (arr[start][i]==1 && check[i]==0) {
                    check[i]=1;
                    DFS(i);
                    check[i]=0;
                }
            }
        }
    }
}
