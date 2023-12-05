package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P02_대소문자변환 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        String answer = "";
        for (char c : letter.toCharArray()) {
            if (65<=c && c<=90) {
                answer += (char)(c+32);
            } else {
                answer += (char)(c-32);
            }
        }

        System.out.println(answer);
    }

    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        String answer = "";
        for (char c : letter.toCharArray()) {
            if (Character.isUpperCase(c)) {
                answer += Character.toLowerCase(c);
            } else {
                answer += Character.toUpperCase(c);
            }
        }

        System.out.println(answer);
    }
}
