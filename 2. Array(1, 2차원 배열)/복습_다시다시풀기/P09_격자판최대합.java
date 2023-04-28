package 복습_다시다시풀기;

import java.util.*;
import java.io.*;

public class P09_격자판최대합 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        int max = 0;
        // 가로 확인
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = 0;
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                row += arr[i][j];
            }
            max = Math.max(max, row);
        }

        // 세로 확인
        for (int i=0; i<N; i++) {
            int one = 0;
            for (int j=0; j<N; j++) {
                one += arr[j][i];
            }
            max = Math.max(max, one);
        }

        // 대각선 확인
        int one = 0;
        int two = 0;
        for (int i=0; i<N; i++) {
            one += arr[i][N-1-i];
            two += arr[i][i];
        }
        max = Math.max(max, one);
        max = Math.max(max, two);

        System.out.println(max);
    }
}
