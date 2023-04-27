package 복습_다시다시풀기;

import java.util.*;
import java.io.*;

public class P05_특정문자뒤집기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        int lt = 0;
        int rt = letter.length()-1;
        char[] arr = letter.toCharArray();

        while (lt < rt) {
            while (!Character.isAlphabetic(arr[lt])) {
                lt++;
            }

            while (!Character.isAlphabetic(arr[rt])) {
                rt--;
            }

            if (lt < rt) {
                char tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;
                lt++;
                rt--;
            }
        }

        String answer = String.valueOf(arr);
        System.out.println(answer);
    }
}
