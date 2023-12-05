package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P10_가장짧은문자거리 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] arr = st.nextToken().toCharArray();
        char c = st.nextToken().charAt(0);

        int[] answer = new int[arr.length];
        Arrays.fill(answer, Integer.MAX_VALUE);

        int now = 200;
        for (int i=0; i<arr.length; i++) {
            now++;
            if (arr[i]==c) {
                now = 0;
            }
            answer[i] = Math.min(answer[i], now);
        }

        now = 200;
        for (int i=arr.length-1; i>=0; i--) {
            now++;
            if (arr[i]==c) {
                now = 0;
            }
            answer[i] = Math.min(answer[i], now);
        }

        for (int one : answer) {
            System.out.print(one+" ");
        }
    }
}
