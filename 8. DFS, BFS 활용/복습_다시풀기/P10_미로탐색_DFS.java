package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P10_미로탐색_DFS {

    static int[][] map = new int[7][7];
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k=0; k<7; k++) {
                map[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        map[0][0] = 1;
        DFS(0, 0);
        System.out.println(answer);
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void DFS(int x, int y) {
        if (x==6 && y==6) {
            answer++;
        } else {
            for (int i=0; i<4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if (0<=nx && nx<=6 && 0<=ny && ny<=6 && map[nx][ny]==0) {
                    map[nx][ny] = 1;
                    DFS(nx, ny);
                    map[nx][ny] = 0;
                }
            }
        }
    }
}
