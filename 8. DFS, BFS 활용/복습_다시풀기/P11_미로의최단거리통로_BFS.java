package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P11_미로의최단거리통로_BFS {

    static int[][] map = new int[7][7];
    static int[][] distance = new int[7][7];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<7; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS();
        System.out.println(distance[6][6] == 0 ? -1 : distance[6][6]);
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void BFS() {
        Queue<Whkby> q = new LinkedList<>();
        q.offer(new Whkby(0, 0));
        map[0][0] = 1;
        distance[0][0] = 0;

        while (!q.isEmpty()) {
            Whkby tmp = q.poll();
            for (int k=0; k<4; k++) {
                int nx = tmp.x + dx[k];
                int ny = tmp.y + dy[k];
                if (0<=nx && nx<7 && 0<=ny && ny<7 && map[nx][ny]==0) {
                    map[nx][ny] = 1;
                    distance[nx][ny] = distance[tmp.x][tmp.y]+1;
                    q.offer(new Whkby(nx, ny));
                }
            }
        }
    }
}

class Whkby {
    int x;
    int y;
    public Whkby(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
