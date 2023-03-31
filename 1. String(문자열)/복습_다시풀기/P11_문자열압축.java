package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P11_문자열압축 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        StringBuilder sb = new StringBuilder();
        char c = letter.charAt(0);
        sb.append(c);
        int count = 1;
        for (int i=1; i<letter.length(); i++) {
            if (c==letter.charAt(i)) {
                count++;
            } else {
                if (count != 1) {
                    sb.append(count);
                }
                c = letter.charAt(i);
                sb.append(c);
                count = 1;
            }
        }
        if (count != 1) {
            sb.append(count);
        }

        System.out.println(sb.toString());
    }
}
