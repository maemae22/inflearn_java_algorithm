package 복습_다시다시풀기;

import java.util.*;
import java.io.*;

public class P06_뒤집은소수 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] reverse = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        for (int i=0; i<N; i++) {
            String reverseNum = new StringBuilder(st.nextToken()).reverse().toString();
            reverse[i] = Integer.parseInt(reverseNum);
            max = Math.max(max, reverse[i]);
        }

        // 0이면 소수, 아니면 소수가 아님.
        int[] sosu = new int[max+1];
        sosu[1] = 1;
        for (int i=2; i<=max; i++) {
            if (sosu[i] == 0) {
                for (int j=2; j*i<=max; j++) {
                    sosu[j*i] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            if (sosu[reverse[i]] == 0) {
                sb.append(reverse[i]).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
