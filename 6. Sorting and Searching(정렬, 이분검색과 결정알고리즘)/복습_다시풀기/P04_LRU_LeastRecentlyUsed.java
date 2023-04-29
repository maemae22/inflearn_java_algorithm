package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P04_LRU_LeastRecentlyUsed {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[S];
        for (int work : arr) {
            boolean contain = false;
            int index = -1;
            for (int i=0; i<answer.length; i++) {
                if (answer[i]==work) {
                    contain = true;
                    index = i;
                }
            }

            if (!contain) {
                index = answer.length-1;
            }

            for (int i=index; i>0; i--) {
                answer[i] = answer[i-1];
            }
            answer[0] = work;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : answer) {
            sb.append(num).append(" ");
        }

        System.out.println(sb.toString());
    }
}
