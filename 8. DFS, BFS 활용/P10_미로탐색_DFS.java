import java.util.*;
import java.io.*;

/*
7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.
출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다.
격자판의 1은 벽이고, 0은 통로이다. 격자판의 움직임은 상하좌우로만 움직인다.
ex.
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 0 0 0 1
1 1 0 1 1 0 0
1 0 0 0 0 0 0
->
8
 */
public class P10_미로탐색_DFS {

    static int[][] arr = new int[7][7];
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<7; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arr[0][0] = 1;
        DFS(0, 0);
        System.out.println(answer);
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void DFS(int x, int y) {
        if (x==6 && y==6) {
            answer++;
//            System.out.println("하나의 경로 끝");
        } else {
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (canGo(nx, ny) && arr[nx][ny]==0) {
                    arr[nx][ny]=1;
//                    System.out.print(nx+","+ny+" | ");
                    DFS(nx, ny);
                    arr[nx][ny]=0;
                }
            }
        }
    }

    public static boolean canGo(int nx, int ny) {
        if (0<=nx && nx<7 && 0<=ny && ny<7) {
            return true;
        }
        return false;
    }
}
