import java.util.*;
import java.io.*;

/*
창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면,
익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며,
토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 현수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,
며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
입력 : 하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다.
      정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
출력 : 여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다.
      만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고,
      토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
ex.
6 4
0 0 -1 0 0 0
0 0 1 0 -1 0
0 0 -1 0 0 0
0 0 0 0 -1 1
->
4
 */
public class P12_토마토_BFS활용 {

    public static int[][] arr;
    static int N, M, day;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS();

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (arr[i][j] == 0) {
                    day = -1;
                }
            }
        }

        System.out.println(day);
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void BFS() {
        Queue<Pointt> q = new LinkedList<>();
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (arr[i][j] == 1) {
                    q.offer(new Pointt(i, j));
                }
            }
        }
        day = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                Pointt tmp = q.poll();
                for (int j=0; j<4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];

                    if (0<=nx && nx<N && 0<=ny && ny<M && arr[nx][ny] == 0) {
                        arr[nx][ny] = 1;
                        q.offer(new Pointt(nx, ny));
                    }
                }
            }
            day++;
        }

        day--;
    }
}

class Pointt {
    int x;
    int y;

    public Pointt(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
