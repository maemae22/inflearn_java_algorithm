package 복습_다시다시풀기;

import java.util.*;
import java.io.*;

public class P02_대소문자변환 {

    public static void main(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        // 로직
        StringBuilder sb = new StringBuilder();

        for (char c : letter.toCharArray()) {
            if (Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }

        // 출력
        System.out.println(sb.toString());
    }

    public static void main2(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        // 로직
        StringBuilder sb = new StringBuilder();

        for (char c : letter.toCharArray()) {
            if (65<=c && c<=90) {
                sb.append((char)(c+32));
            } else {
                sb.append((char)(c-32));
            }
        }

        // 출력
        System.out.println(sb.toString());
    }
}
