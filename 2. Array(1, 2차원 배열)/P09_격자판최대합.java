import java.util.*;
import java.io.*;

/*
N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
ex.
5
10 13 10 12 15
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19
-> 155
 */
public class P09_격자판최대합 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] scores = new int[N+1][N+1];
        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int[] totals = new int[N*2 + 2];
        int totalIndex = 0;
        int total = 0;

        // 가로 더한거 N개
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                total += scores[i][j];
            }
            totals[totalIndex] = total;
            totalIndex++;
            total = 0;
        }

        // 세로 더한거 N개
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                total += scores[j][i];
            }
            totals[totalIndex] = total;
            totalIndex++;
            total = 0;
        }

        // 대각선 더한거 1개
        for (int i=1; i<=N; i++) {
            total += scores[i][i];
        }
        totals[totalIndex] = total;
        totalIndex++;
        total = 0;

        // 대각선 더한거 다른 1개
        for (int i=1; i<=N; i++) {
            total += scores[i][N+1-i];
        }
        totals[totalIndex] = total;

        // 최대 total 값 구하기.
        for (int tmp : totals) {
            if (tmp > max) {
                max = tmp;
            }
        }

        System.out.println(max);
    }

}
