package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P07_점수계산 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int score = 1;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (num==0) {
                score = 1;
            } else {
                answer += score;
                score++;
            }
        }

        System.out.println(answer);
    }
}
