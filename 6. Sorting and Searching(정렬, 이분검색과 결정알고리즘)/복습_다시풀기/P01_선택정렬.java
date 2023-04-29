package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P01_선택정렬 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<N; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j=i; j<N; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(" ");
        }

        System.out.println(sb.toString());
    }
}
