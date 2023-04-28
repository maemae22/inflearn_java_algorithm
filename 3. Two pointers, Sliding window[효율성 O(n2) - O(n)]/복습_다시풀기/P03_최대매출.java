package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P03_최대매출 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] sales = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            sales[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i=0; i<K; i++) {
            max += sales[i];
        }

        int total = max;
        for (int i=0; i<N-K; i++) {
            total -= sales[i];
            total += sales[i+K];
            max = Math.max(max, total);
        }

        System.out.println(max);
    }
}
