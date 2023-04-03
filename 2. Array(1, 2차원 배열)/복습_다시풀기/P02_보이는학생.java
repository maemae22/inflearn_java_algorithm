package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P02_보이는학생 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int count = 0;
        for (int i=0; i<N; i++) {
            if (arr[i] > max) {
                max = arr[i];
                count++;
            }
        }

        System.out.println(count);
    }
}
