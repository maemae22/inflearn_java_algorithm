package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P08_등수구하기 {

    public static void main(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        // 로직
        int[] answer = new int[N];
        for (int i=0; i<N; i++) {
            int top = 0;
            for (int j=0; j<N; j++) {
                if (i!=j && scores[i]<scores[j]) {
                    top++;
                }
            }
            answer[i] = top+1;
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int ans : answer) {
            sb.append(ans).append(" ");
        }

        System.out.println(sb.toString());
    }
}
