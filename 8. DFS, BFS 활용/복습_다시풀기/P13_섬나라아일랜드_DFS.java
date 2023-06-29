package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P13_섬나라아일랜드_DFS {

    static int[][] map;
    static int N, answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+2][N+2];

        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if (map[i][j]==1) {
                    map[i][j]=0;
                    DFS(i, j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    public static void DFS(int x, int y) {

        for (int i=0; i<8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (map[nx][ny]==1) {
                map[nx][ny]=0;
                DFS(nx, ny);
            }
        }
    }
}
