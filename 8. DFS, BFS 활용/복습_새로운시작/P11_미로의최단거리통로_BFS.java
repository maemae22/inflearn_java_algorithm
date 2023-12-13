package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P11_미로의최단거리통로_BFS {

    static int[][] arr = new int[7][7];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<7; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(BFS(arr));
    }

    public static int BFS(int[][] arr) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<Rode> q = new LinkedList<>();
        q.offer(new Rode(0, 0));
        arr[0][0]=1;

        int answer = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                Rode tmp = q.poll();
                for (int k=0; k<4; k++) {
                    int nx = tmp.x+dx[k];
                    int ny = tmp.y+dy[k];
                    if (nx==6 && ny==6) {
                        return answer+1;
                    }
                    if (0<=nx && nx<7 && 0<=ny && ny<7 && arr[nx][ny]==0) {
                        arr[nx][ny]=1;
                        q.offer(new Rode(nx, ny));
                    }
                }
            }
            answer++;
        }

        return -1;
    }
}

class Rode {
    int x;
    int y;
    Rode(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
