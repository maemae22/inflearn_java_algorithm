package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P05_연속된자연수의합 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N/2+1];
        for (int i=0; i<arr.length; i++) {
            arr[i] = i+1;
        }

        int answer = 0;
        int sum = 0;
        int lt = 0;
        for (int rt=0; rt<=N/2; rt++) {
            sum += arr[rt];
            while (sum>N) {
                sum -= arr[lt++];
            }
            if (sum==N) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
