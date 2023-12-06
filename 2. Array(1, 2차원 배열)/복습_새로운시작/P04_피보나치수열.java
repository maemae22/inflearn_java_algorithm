package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P04_피보나치수열 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] answer = new int[N];
        answer[0] = 1;
        answer[1] = 1;
        System.out.print("1 1 ");
        for (int i=2; i<N; i++) {
            answer[i] = answer[i-1] + answer[i-2];
            System.out.print(answer[i]+" ");
        }
    }
}
