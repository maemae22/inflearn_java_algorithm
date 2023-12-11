package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P01_합이같은부분집합_DFS_아마존인터뷰 {

    static int[] arr;
    static int[] check;
    static int N;
    static int sum;
    static boolean find = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        sum = 0;
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        check = new int[N];
        DFS(0);

        if (find) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void DFS(int level) {
        if (find) {
            return;
        }

        if (level==N) {
            int tmp = 0;
            for (int i=0; i<N; i++) {
                if (check[i]==0) {
                    tmp += arr[i];
                }
            }

            if (tmp*2==sum) {
                find = true;
            }
        } else {
            check[level]=1;
            DFS(level+1);

            check[level]=0;
            DFS(level+1);
        }
    }
}
