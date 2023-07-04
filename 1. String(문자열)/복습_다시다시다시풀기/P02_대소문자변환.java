package 복습_다시다시다시풀기;

import java.util.*;
import java.io.*;

public class P02_대소문자변환 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] letters = br.readLine().toCharArray();

        for (int i=0; i<letters.length; i++) {
            if (Character.isLowerCase(letters[i])) {
                letters[i] = Character.toUpperCase(letters[i]);
            } else {
                letters[i] = Character.toLowerCase(letters[i]);
            }
        }

        String answer = String.valueOf(letters);
        System.out.println(answer);
    }
}
