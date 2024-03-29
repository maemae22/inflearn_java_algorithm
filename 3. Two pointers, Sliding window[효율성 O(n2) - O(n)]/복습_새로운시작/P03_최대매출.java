package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P03_최대매출 {

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

        int now = 0;
        for (int i=0; i<K; i++) {
            now += arr[i];
        }

        int answer = now;
        for (int i=K; i<N; i++) {
            now += arr[i];
            now -= arr[i-K];
            answer = Math.max(answer, now);
        }

        System.out.println(answer);
    }
}
