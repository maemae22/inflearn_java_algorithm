package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P06_최대길이연속부분수열 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int change = 0;
        int max = 0;
        int lt = 0;
        for (int rt=0; rt<N; rt++) {
            if (arr[rt]==0 && change<K) {
                change++;
            } else if (arr[rt]==0 && change==K) {
                max = Math.max(max, rt-lt);

                while (arr[lt]==1) {
                    lt++;
                }
                lt++;
            }
        }

        System.out.println(max);
    }
}
