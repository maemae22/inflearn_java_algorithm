package 복습_새로운시작;

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

        int max = 0;
        int now = 0;
        int count = 0;
        int lt = 0;
        for (int rt=0; rt<N; rt++) {
            if (arr[rt]==1) {
                now++;
            } else {
                if (count<K) {
                    count++;
                    now++;
                } else { // count == K
                    while (arr[lt]!=0) {
                        lt++;
                    }
                    now = rt-lt;
                    lt++; // 중요 !!!!
                }
            }
//            System.out.println(now);
            max = Math.max(max, now);
        }

        System.out.println(max);
    }
}
