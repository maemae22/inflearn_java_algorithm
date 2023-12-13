package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P14_섬나라아일랜드_BFS {

    static int[][] arr;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (arr[i][j]==1) {
                    arr[i][j]=0;
                    answer++;
                    BFS(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    public static void BFS(int x, int y) {
        Queue<Dot> q = new LinkedList<>();
        q.offer(new Dot(x, y));

        int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
        int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                Dot tmp = q.poll();
                for (int k=0; k<dx.length; k++) {
                    int nx = tmp.x+dx[k];
                    int ny = tmp.y+dy[k];
                    if (0<=nx && nx<N && 0<=ny && ny<N && arr[nx][ny]==1) {
                        arr[nx][ny]=0;
                        q.offer(new Dot(nx, ny));
                    }
                }
            }
        }
    }
}

class Dot {
    int x;
    int y;
    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
