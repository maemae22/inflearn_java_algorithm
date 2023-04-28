package 복습_다시다시풀기;

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
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                boolean top = true;
                for (int k=0; k<4; k++) {
                    if (arr[i][j] <= arr[i+dx[k]][j+dy[k]]) {
                        top = false;
                        break;
                    }
                }
                if (top) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
