import java.util.*;
import java.io.*;

/*
7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램을 작성하세요.
경로의 길이는 출발점에서 도착점까지 가는데 이동한 횟수를 의미한다.
출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 도로이다.
격자판의 움직임은 상하좌우로만 움직인다.
출력 : 첫 번째 줄에 최단으로 움직인 칸의 수를 출력한다. 도착할 수 없으면 -1를 출력한다.
ex.
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 1 0 0 0
1 0 0 0 1 0 0
1 0 1 0 0 0 0
->
12
 */
public class P11_미로의최단거리통로_BFS {

    static int[][] arr = new int[7][7];
    static int[][] dis = new int[7][7]; // ⭐ 이게 중요 !!

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<7; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arr[0][0] = 1;
        dis[0][0] = 0;
        BFS();

        if (dis[6][6] == 0) {
            System.out.println("-1");
        } else {
            System.out.println(dis[6][6]);
        }
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void BFS() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                Point tmp = q.poll();
                for (int j=0; j<4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];

                    if (canGo(nx, ny) && arr[nx][ny]==0) {
                        q.offer(new Point(nx, ny));
                        arr[nx][ny] = 1;
                        dis[nx][ny] = dis[tmp.x][tmp.y] + 1; // ⭐ 핵심 로직 !!

                        if (nx == 6 && ny == 6) {
                            return;
                        }
                    }
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

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
