import java.util.*;
import java.io.*;

public class P11_그래프와인접행렬 {

    /*
    5 5
    1 2
    1 3
    2 4
    2 5
    3 4
     */
    // 1. 무방향 그래프
    // arr[a][b] = 1;
    // arr[b][a] = 1;
    public static void main1(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1]; // 갈 수 있는 곳은 1, 갈 수 없는 곳은 0으로 표현함 !

        for (int i=0; i<count; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        System.out.println(Arrays.deepToString(arr));
    }

    /*
    5 5
    1 2
    1 3
    2 5
    3 4
    4 2
     */
    // 2. 방향 그래프
    // arr[a][b] = 1;
    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1]; // 갈 수 있는 곳은 1, 갈 수 없는 곳은 0으로 표현함 !

        for (int i=0; i<count; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
        }

        System.out.println(Arrays.deepToString(arr));
    }

    /*
    5 5
    1 2 2
    1 3 4
    2 5 5
    3 4 5
    4 2 2
     */
    // 3. 가중치 방향 그래프
    // arr[a][b] = c;
    public static void main3(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1]; // 갈 수 있는 곳은 가중치 숫자만큼, 갈 수 없는 곳은 0으로 표현함 !

        for (int i=0; i<count; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a][b] = c;
        }

        System.out.println(Arrays.deepToString(arr));
    }
}
