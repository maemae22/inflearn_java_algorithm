package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P08_수열추측하기 {

    static int N, F;
    static int[][] combi;
    static int[] answer;
    static int[] check;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());

        combi = new int[N+1][N+1];

        answer = new int[N];
        check = new int[N+1];
        DFS(0);
        for (int ans : answer) {
            System.out.print(ans+" ");
        }
    }

    public static int Combi(int n, int r) {
        if (n==r || r==0) {
            return combi[n][r] = 1;
        } else if (r==1) {
            return combi[n][r] = n;
        } else if (combi[n][r]!=0) {
            return combi[n][r];
        } else {
            return combi[n][r] = Combi(n-1, r-1) + Combi(n-1, r);
        }
    }

    public static void DFS(int level) {
        if (flag) {
            return;
        }
        if (level == N) {
            int total = 0;
            for (int i=0; i<N; i++) {
                total+=answer[i]*Combi(N-1, i);
            }
            if (total==F) {
                flag = true;
                return;
            }
        } else {
            for (int i=1; i<=N; i++) {
                if (!flag && check[i]==0) {
                    check[i] = 1;
                    answer[level] = i;
                    DFS(level+1);
                    check[i] = 0;
                }
            }
        }
    }
}
