package 복습_다시다시풀기;

import java.util.*;
import java.io.*;

public class P01_큰수출력하기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append(" ");

        for (int i=1; i<N; i++) {
            if (arr[i] > arr[i-1]) {
                sb.append(arr[i]).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
