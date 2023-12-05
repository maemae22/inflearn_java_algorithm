package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P08_유효한팰린드롬 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toUpperCase().toCharArray();

        int lt = 0;
        int rt = arr.length-1;

        String answer = "YES";
        while (lt<rt) {
            while (!Character.isAlphabetic(arr[lt])) {
                lt++;
            }
            while (!Character.isAlphabetic(arr[rt])) {
                rt--;
            }

            if (arr[lt]!=arr[rt]) {
                answer = "NO";
                break;
            }

            lt++;
            rt--;
        }

        System.out.println(answer);
    }
}
