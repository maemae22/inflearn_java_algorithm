package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P03_가위바위보 {

    public static void main(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] B = new int[N];
        for (int i=0; i<N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 로직 & 출력
        for (int i=0; i<N; i++) {
            System.out.println(play(A[i], B[i]));
        }
    }

    public static char play(int a, int b) {
        if (a==b) {
            return 'D';
        } else if ( (a == 1 && b == 3) || (a == 2 && b == 1) || (a == 3 && b == 2) ) {
            return 'A';
        } else {
            return 'B';
        }
    }
}
