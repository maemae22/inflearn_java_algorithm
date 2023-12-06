package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P05_소수_에라토스테네스체 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int[] sosu = new int[N+1];

        for (int i=2; i<=N; i++) {
            if (sosu[i]==0) {
                answer++;
                for (int j=1; j*i<=N; j++) {
                    sosu[j*i]=1;
                }
            }
        }

        System.out.println(answer);
    }
}
