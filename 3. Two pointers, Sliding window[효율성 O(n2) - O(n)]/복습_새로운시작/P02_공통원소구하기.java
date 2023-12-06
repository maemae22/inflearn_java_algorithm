package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P02_공통원소구하기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] b = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int pa = 0;
        int pb = 0;

        while (pa<N && pb<M) {
            if (a[pa]==b[pb]) {
                System.out.print(a[pa++]+" ");
                pb++;
            } else if (a[pa]>b[pb]) {
                pb++;
            } else {
                pa++;
            }
        }
    }
}
