package 복습_다시다시풀기;

import java.util.*;
import java.io.*;

public class P03_문장속단어 {

    public static void main(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 로직
        String answer = "";
        while (st.hasMoreTokens()) {
            String next = st.nextToken();
            if (next.length() > answer.length()) {
                answer = next;
            }
        }

        // 출력
        System.out.println(answer);
    }
}
