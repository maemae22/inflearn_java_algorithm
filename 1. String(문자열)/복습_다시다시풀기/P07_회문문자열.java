package 복습_다시다시풀기;

import java.util.*;
import java.io.*;

public class P07_회문문자열 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine().toUpperCase();

        String reverse = new StringBuilder(letter).reverse().toString();

        if (letter.equals(reverse)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
