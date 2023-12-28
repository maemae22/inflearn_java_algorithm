package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P03_최대부분증가수열_LIS {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dy = new int[N];
        Arrays.fill(dy, 1);
        int answer = 1;
        for (int i=1; i<N; i++) {
            for (int j=0; j<i; j++) {
                if (arr[j]<arr[i]) {
                    dy[i] = Math.max(dy[i], dy[j]+1);
                    answer = Math.max(answer, dy[i]);
                }
            }
        }

        System.out.println(answer);
    }
}
