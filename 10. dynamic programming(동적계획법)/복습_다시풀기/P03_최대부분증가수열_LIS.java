package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P03_최대부분증가수열_LIS {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dy[i] = arr[i]번째 수가 마지막 수가 되는 최대 부분 증가수열의 길이
        int[] dy = new int[N];
        dy[0] = 1;
        for (int i=1; i<N; i++) {
            boolean change = false;
            for (int k=0; k<i; k++) {
                if (arr[k]<arr[i]) {
                    change = true;
                    dy[i] = Math.max(dy[i], dy[k]+1);
                }
            }
            if (!change) {
                dy[i] = 1;
            }
        }

        int answer = 0;
        for (int tmp : dy) {
            answer = Math.max(answer, tmp);
        }
        System.out.println(answer);
    }
}
