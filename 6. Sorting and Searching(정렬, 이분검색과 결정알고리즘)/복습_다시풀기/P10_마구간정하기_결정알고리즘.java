package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P10_마구간정하기_결정알고리즘 {

    static int C;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lt = 1;
        int rt = arr[N-1];
        int answer = 0;

        while (lt<=rt) {
            int mid = (lt+rt)/2;
            if (canPut(mid)) {
                answer = mid;
                lt = mid+1;
            } else {
                rt = mid-1;
            }
        }

        System.out.println(answer);
    }

    public static boolean canPut(int distance) {
        int ep = arr[0];
        int count = 1;

        for (int i=1; i<arr.length; i++) {
            if (arr[i]-ep>=distance) {
                ep = arr[i];
                count++;
            }
        }

        if (count >= C) {
            return true;
        } else {
            return false;
        }
    }
}
