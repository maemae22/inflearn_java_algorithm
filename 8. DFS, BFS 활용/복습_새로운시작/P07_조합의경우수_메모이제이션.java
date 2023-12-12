package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P07_조합의경우수_메모이제이션 {

    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        arr = new int[n+1][r+1];
        System.out.println(DFS(n, r));
    }

    public static int DFS(int n, int r) {
        if (arr[n][r]!=0) {
            return arr[n][r];
        } else if (n==r) {
            return arr[n][r]=1;
        } else if (r==1) {
            return arr[n][r]=n;
        } else {
            return arr[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
        }
    }
}
