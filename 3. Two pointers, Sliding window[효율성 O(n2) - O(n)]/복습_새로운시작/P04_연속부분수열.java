package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P04_연속부분수열 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int now = 0;
        int lt = 0;
        for (int rt=0; rt<N; rt++) {
            now += arr[rt];
            while (now>M) {
                now -= arr[lt++];
            }
            if (now==M) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
