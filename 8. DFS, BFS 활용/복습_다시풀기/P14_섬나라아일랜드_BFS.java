package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P14_섬나라아일랜드_BFS {

    static int N, answer;
    static int[][] map;

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
                    BFS(i, j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};
    public static void BFS(int x, int y) {
        Queue<Loc> q = new LinkedList<>();
        q.offer(new Loc(x, y));

        while (!q.isEmpty()) {
            Loc tmp = q.poll();
            for (int i=0; i<8; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (map[nx][ny]==1) {
                    map[nx][ny]=0;
                    q.offer(new Loc(nx, ny));
                }
            }
        }
    }
}

class Loc {
    int x;
    int y;
    Loc(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
