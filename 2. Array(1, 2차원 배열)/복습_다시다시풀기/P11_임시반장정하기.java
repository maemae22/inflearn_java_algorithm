package 복습_다시다시풀기;

import java.util.*;
import java.io.*;

public class P11_임시반장정하기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][5];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        int max = 0;
        for (int i=0; i<N; i++) {
            int count = 0;
            for (int j=0; j<N; j++) {
                for (int k=0; k<5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        count++;
                        break;
                    }
                }
            }
            if (count > max) {
                max = count;
                answer = i;
            }
        }

        System.out.println(answer+1);
    }
}
