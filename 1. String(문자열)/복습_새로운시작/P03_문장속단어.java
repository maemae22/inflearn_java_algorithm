package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P03_문장속단어 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String answer = "";
        int max = 0;

        while (st.hasMoreTokens()) {
            String tmp = st.nextToken();
            if (tmp.length() > max) {
                max = tmp.length();
                answer = tmp;
            }
        }

        System.out.println(answer);
    }
}
