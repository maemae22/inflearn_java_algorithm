package 복습_다시다시풀기;

import java.util.*;
import java.io.*;

public class P09_숫자만추출 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (char c : letter.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }

        int answer = Integer.parseInt(sb.toString());
        System.out.println(answer);
    }
}
