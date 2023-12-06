package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P01_두배열합치기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] b = new int[M];
        for (int i=0; i<M; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int ap = 0;
        int bp = 0;
        for (int i=1; i<=N+M; i++) {
            if (ap<N && bp<M) {
                if (a[ap] >= b[bp]) {
                    System.out.print(b[bp++] + " ");
                } else {
                    System.out.print(a[ap++] + " ");
                }
            } else if (ap==N) {
                System.out.print(b[bp++] + " ");
            } else { // bp==M
                System.out.print(a[ap++] + " ");
            }
        }
    }
}
