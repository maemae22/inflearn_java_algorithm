package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P04_피보나치수열 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        arr[0] = 1;
        arr[1] = 1;
        for (int i=2; i<N; i++) {
            arr[i] = arr[i-2] + arr[i-1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
