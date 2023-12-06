package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P02_보이는학생 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int max = 0;
        while (st.hasMoreTokens()) {
            int now = Integer.parseInt(st.nextToken());
            if (now>max) {
                answer++;
                max = now;
            }
        }

        System.out.println(answer);
    }
}
