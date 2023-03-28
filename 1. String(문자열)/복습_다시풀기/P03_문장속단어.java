package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P03_문장속단어 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        String answer = "";

        while(st.hasMoreTokens()) {
            String letter = st.nextToken();
            if (letter.length() > max) {
                answer = letter;
                max = letter.length();
            }
        }

        System.out.println(answer);
    }
}
