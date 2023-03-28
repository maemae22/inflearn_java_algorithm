package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P01_문자찾기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine().toUpperCase();
        char c = Character.toUpperCase(br.readLine().charAt(0));

        int count = 0;
        for (char ch : letter.toCharArray()) {
            if (ch == c) {
                count++;
            }
        }

        System.out.println(count);
    }
}
