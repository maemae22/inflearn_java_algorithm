package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P04_피보나치수열_재귀_메모이제이션 {

    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        DFS(N);
        for (int i=1; i<=N; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static int DFS(int N) {
        if (N==1 || N==2) {
            return arr[N]=1;
        } else if (arr[N]!=0) {
            return arr[N];
        } else {
            return arr[N]=DFS(N-2) + DFS(N-1);
        }
    }
}
