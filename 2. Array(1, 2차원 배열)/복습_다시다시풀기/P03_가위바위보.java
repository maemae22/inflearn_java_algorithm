package 복습_다시다시풀기;

import java.util.*;
import java.io.*;

public class P03_가위바위보 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        int[] b = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<N; i++) {
            System.out.println(game(a[i], b[i]));
        }
    }

    public static char game(int a, int b) {
        if (a == b) {
            return 'D';
        } else if (a==1&&b==3 || a==2&&b==1 || a==3&&b==2) {
            return 'A';
        } else {
            return 'B';
        }
    }
}
