package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P05_연속된자연수의합 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        int lt = 1;
        int sum = 0;
        for (int rt=1; rt<N; rt++) {
            sum += rt;
            if (sum == N) {
                answer++;
            }
            while (sum >= N) {
                sum -= lt;
                lt++;
                if (sum == N) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
