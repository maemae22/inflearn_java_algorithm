package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P12_토마토_BFS활용 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(BFS(arr));
    }

    public static int BFS(int[][] arr) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<Tomato> q = new LinkedList<>();
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[0].length; j++) {
                if (arr[i][j]==1) {
                    q.offer(new Tomato(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                Tomato tmp = q.poll();
                for (int k=0; k<4; k++) {
                    int nx = tmp.x+dx[k];
                    int ny = tmp.y+dy[k];
                    if (0<=nx && nx<arr.length && 0<=ny && ny<arr[0].length && arr[nx][ny]==0) {
                        arr[nx][ny]=arr[tmp.x][tmp.y]+1;
                        q.offer(new Tomato(nx, ny));
                    }
                }
            }
        }

        int answer = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[0].length; j++) {
                if (arr[i][j]==0) {
                    return -1;
                }
                answer = Math.max(answer, arr[i][j]);
            }
        }

        return answer-1;
    }
}

class Tomato {
    int x;
    int y;
    Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
