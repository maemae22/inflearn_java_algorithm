package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P10_마구간정하기_결정알고리즘 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lt = 1;
        int rt = (arr[0]+arr[N-1])/(C-1);
        int answer = 0;
        while (lt<=rt) {
            int mid = (lt+rt)/2;
            if (canDivide(arr, C, mid)) {
                lt = mid+1;
                answer = mid;
            } else {
                rt = mid-1;
            }
        }

        System.out.println(answer);
    }

    public static boolean canDivide(int[] arr, int C, int length) {
        int count = 1;
        int index = 0;
        for (int i=1; i<arr.length; i++) {
            if (arr[i]-arr[index]>=length) {
                count++;
                index = i;
            }
        }

        if (count>=C) {
            return true;
        } else {
            return false;
        }
    }
}
