package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P13_섬나라아일랜드_DFS {

    static int[][] arr;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (arr[i][j]==1) {
                    arr[i][j]=0;
                    answer++;
                    DFS(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
    public static void DFS(int x, int y) {
        for (int i=0; i<8; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if (0<=nx && nx<arr.length && 0<=ny && ny<arr.length && arr[nx][ny]==1) {
                arr[nx][ny]=0;
                DFS(nx, ny);
            }
        }
    }
}
