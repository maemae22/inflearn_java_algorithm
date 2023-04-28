package 복습_다시다시풀기;

import java.util.*;
import java.io.*;

public class P12_멘토링 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                int studentNum = Integer.parseInt(st.nextToken());
                arr[studentNum-1][i] = j;
            }
        }

        int answer = 0;
        for (int i=0; i<N; i++) { // i번째 학생이 멘토인 경우
            int count = 0;
            for (int j=0; j<N; j++) {
                boolean mento = true;
                for (int k=0; k<M; k++) {
                    if (arr[i][k] >= arr[j][k]) {
                        mento = false;
                        break;
                    }
                }
                if (mento) {
                    count++;
                }
            }
            answer += count;
        }

        System.out.println(answer);
    }
}
