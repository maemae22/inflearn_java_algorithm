package 복습_다시다시풀기;

import java.util.*;
import java.io.*;

public class P05_소수_에라토스테네스체 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 0이면 소수, 아니면 소수가 아님.
        int[] sosu = new int[N+1];
        int count = 0;

        for (int i=2; i<=N; i++) {
            if (sosu[i] == 0) {
                count++;
                for (int j=2; j*i<=N; j++) {
                    sosu[j*i] = 1;
                }
            }
        }

        System.out.println(count);
    }

    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i=2; i<=N; i++) {
            boolean sosu = true;
            for (int j=2; j<=Math.sqrt(i); j++) {
                if (i%j==0) {
                    sosu = false;
                    break;
                }
            }
            if (sosu) {
                count++;
            }
        }

        System.out.println(count);
    }
}
