package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P05_동전교환_냅색알고리즘 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int[] dy = new int[M+1];
        Arrays.fill(dy, M);
        for (int coin : arr) {
            dy[coin]=1;
            for (int i=coin+1; i<=M; i++) {
                dy[i] = Math.min(dy[i], dy[i-coin]+1);
            }
        }

        System.out.println(dy[M]);
    }
}
