import java.util.*;
import java.io.*;

/*
N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.
각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.
섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.
ex.
7
1 1 0 0 0 1 0
0 1 1 0 1 1 0
0 1 0 0 0 0 0
0 0 0 1 0 1 1
1 1 0 1 1 0 0
1 0 0 0 1 0 0
1 0 1 0 1 0 0
->
5
 */
public class P14_섬나라아일랜드_BFS {

    static int N, answer;
    static int[][] arr;

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

        BFS();
        System.out.println(answer);
    }

    static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

    public static void BFS () {
        Queue<Dots> q = new LinkedList<>();

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (arr[i][j] == 1) {
                    arr[i][j] = 0;
                    q.offer(new Dots(i, j));

                    while (!q.isEmpty()) {
                        Dots tmp = q.poll();
                        for (int k=0; k<dx.length; k++) {
                            int nx = tmp.x + dx[k];
                            int ny = tmp.y + dy[k];

                            if (canGo(nx, ny) && arr[nx][ny]==1) {
                                arr[nx][ny] = 0;
                                q.offer(new Dots(nx, ny));
                            }
                        }
                    }

                    answer++;
                }
            }
        }
    }

    public static boolean canGo(int nx, int ny) {
        if (0<=nx && nx<N && 0<=ny && ny<N) {
            return true;
        }
        return false;
    }
}

class Dots {
    int x;
    int y;

    public Dots (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
