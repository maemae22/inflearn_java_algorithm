package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P12_멘토링 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][M+1];
        for (int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                int studentNum = Integer.parseInt(st.nextToken());
                arr[studentNum][i] = j;
            }
        }

        int answer = 0;
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                boolean can = true;
                for (int k=1; k<=M; k++) {
                    if (arr[i][k]>=arr[j][k]) {
                        can = false;
                        break;
                    }
                }
                if (can) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
