package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P12_토마토_BFS활용 {

    static int N, M, answer;
    static int[][] box;
    static int[][] days;
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        days = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j]==1) {
                    q.offer(new Point(i, j));
                } else if (box[i][j]==0) {
                    days[i][j] = -1;
                }
            }
        }

        BFS();
        System.out.println(answer);
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void BFS() {

        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i=0; i<4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (0<=nx && nx<N && 0<=ny && ny<M && days[nx][ny]==-1) {
                    days[nx][ny] = days[tmp.x][tmp.y]+1;
                    q.offer(new Point(nx, ny));
                }
            }
        }

        answer = Integer.MIN_VALUE;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (days[i][j]==-1) {
                    answer = -1;
                    return;
                } else {
                    answer = Math.max(answer, days[i][j]);
                }
            }
        }
    }
}

class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
