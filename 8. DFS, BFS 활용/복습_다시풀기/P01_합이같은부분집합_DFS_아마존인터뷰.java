package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P01_합이같은부분집합_DFS_아마존인터뷰 {

    static String answer;
    static int sum;
    static int total;
    static boolean find;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        total = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        answer = "NO";
        find = false;
        DFS(N, arr, 0);
        System.out.println(answer);
    }

    public static void DFS(int N, int[] arr, int level) {
        if (find) {
            return;
        }
        if (level==N) {
            if (sum*2==total) {
                answer = "YES";
                find = true;
            }
        } else {
            sum += arr[level];
            DFS(N, arr, level+1);

            sum -= arr[level];
            DFS(N, arr, level+1);
        }
    }
}
