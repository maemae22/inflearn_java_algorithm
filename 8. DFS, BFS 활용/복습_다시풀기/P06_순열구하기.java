package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P06_순열구하기 {

    static int N, M;
    static int[] answer;
    static int[] check;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        answer = new int[M];
        check = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0);
    }

    public static void DFS(int level) {
        if (level == M) {
            for (int i=0; i<M; i++) {
                System.out.print(answer[i]+" ");
            }
            System.out.println();
        } else {
            for (int i=0; i<N; i++) {
                if (check[i]==0) {
                    check[i]=1;
                    answer[level]=arr[i];
                    DFS(level+1);
                    check[i]=0;
                }
            }
        }
    }
}
