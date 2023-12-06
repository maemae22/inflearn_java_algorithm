package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P08_등수구하기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] scores = new int[N];
        for (int i=0; i<N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<N; i++) {
            int count = 0;
            for (int j=0; j<N; j++) {
                if (scores[j]>scores[i]) {
                    count++;
                }
            }
            System.out.print((count+1)+" ");
        }
    }
}
