package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P10_미로탐색_DFS {

    static int[][] arr;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[7][7];
        for (int i=0; i<7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<7; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arr[0][0]=1;
        DFS(0, 0);
        System.out.println(answer);
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void DFS(int x, int y) {
        if (x==6 && y==6) {
            answer++;
        } else {
            for (int i=0; i<4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if (0<=nx && nx<7 && 0<=ny && ny<7 && arr[nx][ny]==0) {
                    arr[nx][ny]=1;
                    DFS(nx, ny);
                    arr[nx][ny]=0;
                }
            }
        }
    }
}
