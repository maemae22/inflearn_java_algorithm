package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P06_장난꾸러기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] clone = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            clone[i] = arr[i];
        }

        Arrays.sort(clone);

        for (int i=0; i<N; i++) {
            if (arr[i]!=clone[i]) {
                System.out.print((i+1)+" ");
            }
        }
    }
}
