package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P01_계단오르기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        arr[0]=1;
        arr[1]=1;
        for (int i=2; i<=N; i++) {
            arr[i] = arr[i-2] + arr[i-1];
        }

        System.out.println(arr[N]);
    }
}
