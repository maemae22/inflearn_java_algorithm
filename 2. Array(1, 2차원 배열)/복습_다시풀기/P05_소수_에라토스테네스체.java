package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P05_소수_에라토스테네스체 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1]; // 소수면 0, 아니면 1로 표현
        for (int i=2; i<=N; i++) {
            if (arr[i]==0) {
                for (int j=2; j<=N/i; j++) {
                    arr[j*i] = 1;
                }
            }
        }

        int answer = 0;
        for (int i=2; i<=N; i++) {
            if (arr[i]==0) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
