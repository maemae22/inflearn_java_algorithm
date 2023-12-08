package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P09_뮤직비디오_결정알고리즘 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        int lt = 1;
        int rt = sum;
        while (lt<=rt) {
            int mid = (lt+rt)/2;
            if (canDivide(arr, M, mid)) {
                rt = mid-1;
            } else {
                lt = mid+1;
            }
        }

        System.out.println(lt);
    }

    public static boolean canDivide(int[] arr, int M, int length) {
        int count = 1;
        int now = 0;
        for (int tmp : arr) {
            if (now+tmp<=length) {
                now += tmp;
            } else {
                count++;
                now = tmp;
            }
            if (count > M) {
                return false;
            }
        }

        return true;
    }
}
