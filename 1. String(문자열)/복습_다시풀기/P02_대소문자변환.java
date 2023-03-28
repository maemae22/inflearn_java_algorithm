package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P02_대소문자변환 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (char c : letter.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(Character.toUpperCase(c));
            }
        }

        System.out.println(sb.toString());
    }
}
