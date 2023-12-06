package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P09_격자판최대합 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        int tmp3 = 0;
        int tmp4 = 0;
        for (int i=0; i<N; i++) {
            int tmp1 = 0;
            int tmp2 = 0;
            for (int j=0; j<N; j++) {
                tmp1 += arr[i][j];
                tmp2 += arr[j][i];
                if (i==j) {
                    tmp3 += arr[i][j];
                }
                if (i+j==N-1) {
                    tmp4 += arr[i][j];
                }
            }
            answer = Math.max(answer, tmp1);
            answer = Math.max(answer, tmp2);
        }

        answer = Math.max(answer, tmp3);
        answer = Math.max(answer, tmp4);

        System.out.println(answer);
    }
}
