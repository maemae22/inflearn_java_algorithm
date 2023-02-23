import java.util.*;
import java.io.*;

/*
지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
격자의 가장자리는 0으로 초기화 되었다고 가정한다.
ex.
5
5 3 7 2 3
3 7 1 6 1
7 2 5 3 4
4 3 6 4 1
8 7 3 5 2
-> 10
 */
public class P10_봉우리 {

    // 방법1. if문 안에서 4방향을 직접 비교
    public static void main1(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N+2][N+2];
        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                int tmp = map[i][j];
                boolean yes = true;
                if (tmp <= map[i-1][j] || tmp <= map[i][j+1] || tmp <= map[i][j-1] || tmp <= map[i+1][j]) {
                    yes = false;
                }

                if (yes) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    // 방법2. 방향배열 dx, dy를 생성하여 4방향을 for문(4번 반복)으로 비교한다 !
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N+2][N+2];
        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;

        // ⭐ 탐색할 방향을 배열로 만들어두기 (x, y 각각 방향배열 총 2개 생성)
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                boolean yes = true;
                for (int k=0; k<4; k++) { // 방향 배열을 돌면서 하나씩 비교
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (map[nx][ny] >= map[i][j]) {
                        yes = false;
                        break;
                    }
                }
                if (yes) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    // 방법3. new int[N][N]; 으로 만들었을 때, 모서리 예외처리 하는 방법 ! (로직 자체는 방법2와 유사)
    public static void main3(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;

        // ⭐ 탐색할 방향을 배열로 만들어두기 (x, y 각각 방향배열 총 2개 생성)
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                boolean yes = true;
                for (int k=0; k<4; k++) { // 방향 배열을 돌면서 하나씩 비교
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    // ⭐ 모서리 예외처리 : nx, ny 가 0<= <N 사이일 때만 비교함 !!
                    if ( 0<=nx && nx<N && 0<=ny && ny<N && map[nx][ny] >= map[i][j]) {
                        yes = false;
                        break;
                    }
                }
                if (yes) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
