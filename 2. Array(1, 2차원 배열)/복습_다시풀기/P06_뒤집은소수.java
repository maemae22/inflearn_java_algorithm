package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P06_뒤집은소수 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i=0; i<N; i++) {
            sb.setLength(0);
            sb.append(st.nextToken()).reverse();
            arr[i] = Integer.parseInt(sb.toString());
            max = Math.max(max, arr[i]);
        }

        int[] sosu = new int[max+1]; // 소수면 0, 아니면 1로 표현
        sosu[1] = 1;
        for (int i=2; i<=max; i++) {
            if (sosu[i]==0) {
                for (int j=2; j<=max/i; j++) {
                    sosu[j*i] = 1;
                }
            }
        }

        sb.setLength(0);
        for (int i=0; i<N; i++) {
            if (sosu[arr[i]]==0) {
                sb.append(arr[i]).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
