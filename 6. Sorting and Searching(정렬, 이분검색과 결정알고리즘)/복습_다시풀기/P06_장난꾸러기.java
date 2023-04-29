package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P06_장난꾸러기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] real = arr.clone();
        Arrays.sort(real);
        int first = -1;
        int second = -1;

        for (int i=0; i<N; i++) {
            if (arr[i] != real[i]) {
                if (first == -1) {
                    first = i+1;
                } else {
                    second = i+1;
                }
            }
        }

        System.out.println(first+" "+second);
    }
}
