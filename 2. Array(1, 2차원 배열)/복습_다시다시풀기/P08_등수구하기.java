package 복습_다시다시풀기;

import java.util.*;
import java.io.*;

public class P08_등수구하기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            int num = 1;
            for (int j=0; j<N; j++) {
                if (scores[j] > scores[i]) {
                    num++;
                }
            }
            sb.append(num).append(" ");
        }

        System.out.println(sb.toString());
    }
}
