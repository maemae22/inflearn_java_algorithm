package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P01_씨름선수 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int[] tmp : arr) {
            boolean pick = true;
            for (int[] one : arr) {
                if (one[0]>tmp[0] && one[1]>tmp[1]) {
                    pick = false;
                    break;
                }
            }
            if (pick) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
