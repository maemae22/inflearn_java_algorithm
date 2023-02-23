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
}
