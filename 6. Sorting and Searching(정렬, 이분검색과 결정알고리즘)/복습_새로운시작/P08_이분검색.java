package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P08_이분검색 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int lt = 0;
        int rt = N-1;

        int answer = 0;
        while (lt<=rt) {
            int mid = (lt+rt)/2;
            if (M<arr[mid]) {
                rt = mid-1;
            } else if (M>arr[mid]) {
                lt = mid+1;
            } else {
                answer = mid+1;
                break;
            }
        }

        System.out.println(answer);
    }
}
