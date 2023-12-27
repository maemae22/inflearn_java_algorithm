package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P06_친구인가_Disjoint_Set_Union_Find {

    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] tmp = new int[M+1][2];
        for (int i=0; i<M+1; i++) {
            st = new StringTokenizer(br.readLine());
            tmp[i][0] = Integer.parseInt(st.nextToken());
            tmp[i][1] = Integer.parseInt(st.nextToken());
        }

        arr = new int[N+1];
        for (int i=1; i<=N; i++) {
            arr[i]=i;
        }

        for (int i=0; i<M; i++) {
            union(tmp[i][0], tmp[i][1]);
        }

        if (find(tmp[M][0])==find(tmp[M][1])) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void union(int a, int b) {
        if (find(a)!=find(b)) {
            arr[find(b)] = find(a);
        }
    }

    public static int find(int a) {
        if (arr[a]==a) {
            return a;
        } else {
            return arr[a] = find(arr[a]);
        }
    }
}
