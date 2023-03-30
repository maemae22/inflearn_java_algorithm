package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P08_유효한팰린드롬 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine().toUpperCase();

        String target = letter.replaceAll("[^A-Z]", "");
        String reverse = new StringBuilder(target).reverse().toString();

        if (target.equals(reverse)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
