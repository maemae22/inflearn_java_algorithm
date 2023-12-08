package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P03_삽입정렬 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<N; i++) {
            int index = 0;
            for (int j=i-1; j>=0; j--) {
                if (arr[j]<=arr[i]) {
                    index = j+1;
                    break;
                }
            }
            int tmp = arr[i];
            for (int j=i; j>index; j--) {
                arr[j] = arr[j-1];
            }
            arr[index] = tmp;
        }

        for (int tmp : arr) {
            System.out.print(tmp+" ");
        }
    }
}
