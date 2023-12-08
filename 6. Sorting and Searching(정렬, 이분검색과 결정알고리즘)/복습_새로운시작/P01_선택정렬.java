package 복습_새로운시작;

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
            int min = arr[i];
            int index = i;
            for (int j=i+1; j<N; j++) {
                if (min>arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            if (index!=i) {
                int tmp = arr[i];
                arr[i] = arr[index];
                arr[index] = tmp;
            }
        }

        for (int tmp : arr) {
            System.out.print(tmp+" ");
        }
    }
}
