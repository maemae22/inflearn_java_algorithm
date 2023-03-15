import java.util.*;
import java.io.*;

// 다음 공식을 사용하여 재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.
// nCr = n-1Cr-1 + n-1Cr
// ex1. 5 3 -> 10
// ex2. 33 19 -> 818809200
public class P07_조합의경우수_메모이제이션 {

    static int n, r;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n+1][r+1];

        DFS(n, r);
        System.out.println(arr[n][r]);
    }

    public static int DFS(int n, int r) {
        if (n==r) {
            return 1;
        }
        if (r==1) {
            return n;
        }
        if (arr[n][r]!=0) {
            return arr[n][r];
        }

        return arr[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
    }
}
