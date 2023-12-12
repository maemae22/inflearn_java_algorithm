package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P06_순열구하기 {

    static int[] arr;
    static int N, M;
    static int[] answer;
    static int[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        answer = new int[M];
        check = new int[N];
        DFS(0);
    }

    public static void DFS(int index) {
        if (index==M) {
            for (int tmp : answer) {
                System.out.print(tmp+" ");
            }
            System.out.println();
        } else {
            for (int i=0; i<N; i++) {
                if (check[i]==0) {
                    check[i]=1;
                    answer[index]=arr[i];
                    DFS(index+1);
                    check[i]=0;
                }
            }
        }
    }
}
