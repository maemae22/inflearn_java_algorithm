package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P10_봉우리 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+2][N+2];

        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if (arr[i][j]>arr[i+1][j] && arr[i][j]>arr[i-1][j]
                        && arr[i][j]>arr[i][j+1] && arr[i][j]>arr[i][j-1]) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
