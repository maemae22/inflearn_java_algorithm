package 복습_다시다시풀기;

import java.util.*;
import java.io.*;

public class P11_문자열압축 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        int count = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(letter.charAt(0));

        for (int i=1; i<letter.length(); i++) {
            if (letter.charAt(i) != letter.charAt(i-1)) {
                if (count != 1) {
                    sb.append(count);
                }
                count = 1;
                sb.append(letter.charAt(i));
            } else {
                count++;
            }
        }

        if (count != 1) {
            sb.append(count);
        }

        System.out.println(sb.toString());
    }
}
