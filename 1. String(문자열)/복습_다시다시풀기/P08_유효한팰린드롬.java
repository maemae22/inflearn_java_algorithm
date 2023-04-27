package 복습_다시다시풀기;

import java.util.*;
import java.io.*;

public class P08_유효한팰린드롬 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (char c : letter.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                sb.append(c);
            }
        }

        String real = sb.toString();
        String reverse = new StringBuilder(real).reverse().toString();

        if (real.equalsIgnoreCase(reverse)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
