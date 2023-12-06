package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P03_가위바위보 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[N];
        for (int i=0; i<N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[] b = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<N; i++) {
            if (a[i]==b[i]) {
                System.out.println("D");
            } else if (a[i]==1&&b[i]==3 || a[i]==2&&b[i]==1 || a[i]==3&&b[i]==2) {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
        }
    }
}
