package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P08_수열추측하기 {

    static int[] answer;
    static int[] check;
    static int[][] combi;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int F = Integer.parseInt(st.nextToken());

        answer = new int[N];
        check = new int[N+1];
        combi = new int[N+1][N+1];
        DFS(0, N, F);
    }

    static boolean flag = false;
    public static void DFS(int index, int N, int F) {
        if (flag) {
            return;
        }

        if (index==N) {
            int sum = 0;
            for (int i=0; i<N; i++) {
                sum += answer[i]*Combi(N-1, i);
            }
            if (sum==F) {
                flag = true;
                for (int tmp : answer) {
                    System.out.print(tmp+" ");
                }
            }
        } else {
            for (int i=1; i<=N; i++) {
                if (check[i]==0) {
                    check[i]=1;
                    answer[index]=i;
                    DFS(index+1, N, F);
                    check[i]=0;
                }
            }
        }
    }

    public static int Combi(int n, int r) {
        if (combi[n][r]!=0) {
            return combi[n][r];
        } else if (n==r || r==0) {
            return combi[n][r]=1;
        } else if (r==1) {
            return combi[n][r]=n;
        } else {
            return combi[n][r]=Combi(n-1, r-1) + Combi(n-1, r);
        }
    }
}
