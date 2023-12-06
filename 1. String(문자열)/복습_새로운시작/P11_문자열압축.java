package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P11_문자열압축 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        char c = ' ';
        int count = 1;
        StringBuilder sb = new StringBuilder();

        for (char tmp : letter.toCharArray()) {
            if (c==tmp) {
                count++;
            } else {
                if (count!=1) {
                    sb.append(count);
                }
                sb.append(tmp);
                c = tmp;
                count = 1;
            }
        }

        if (count!=1) {
            sb.append(count);
        }

        System.out.println(sb.toString());
    }
}
