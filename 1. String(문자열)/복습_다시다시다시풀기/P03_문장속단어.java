package 복습_다시다시다시풀기;

import java.util.*;
import java.io.*;

public class P03_문장속단어 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String answer = "";
        while (st.hasMoreTokens()) {
            String tmp = st.nextToken();
            if (tmp.length() > answer.length()) {
                answer = tmp;
            }
        }

        System.out.println(answer);
    }
}
