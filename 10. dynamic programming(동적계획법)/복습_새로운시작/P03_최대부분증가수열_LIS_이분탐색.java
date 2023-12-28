package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P03_최대부분증가수열_LIS_이분탐색 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0;
        int[] dp = new int[N];
        dp[0] = arr[0];
        for (int i=1; i<N; i++) {
            if (dp[index]<arr[i]) {
                index++;
                dp[index]=arr[i];
            } else {
                int push = binary(dp, 0, index, arr[i]);
                dp[push] = arr[i];
            }
        }

        System.out.println(index+1);
    }

    public static int binary(int[] arr, int start, int end, int target) {
        int lt = start;
        int rt = end;
        int index = 0;
        while (lt<=rt) {
            int mid = (lt+rt)/2;
            if (target<=arr[mid]) {
                rt = mid-1;
                index = mid;
            } else {
                lt = mid+1;
            }
        }

        return index;
    }
}
