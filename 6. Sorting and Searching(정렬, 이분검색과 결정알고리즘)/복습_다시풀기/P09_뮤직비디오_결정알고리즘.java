package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P09_뮤직비디오_결정알고리즘 {

    static int[] arr;
    static int M;

    public static void main(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        int sum = 0;
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }

        // 로직
        int lt = max;
        int rt = sum;
        int answer = 0;
        while (lt <= rt) {
            int mid = (lt+rt)/2;
            if (canDivide(mid)) {
                answer = mid;
                rt = mid-1;
            } else {
                lt = mid+1;
            }
        }

        // 출력
        System.out.println(answer);
    }

    public static boolean canDivide(int size) {
        int total = 1;
        int sum = 0;
        for (int num : arr) {
            if (sum+num <= size) {
                sum += num;
            } else {
                total++;
                sum = num;
            }
            if (total > M) {
                return false;
            }
        }
        return true;
    }
}
