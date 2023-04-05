package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P07_점수계산 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int total = 0;
        int score = 0;
        for (int check : arr) {
            if (check == 0) {
                score = 0;
            } else {
                score++;
                total += score;
            }
        }

        System.out.println(total);
    }
}
