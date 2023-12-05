package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P05_특정문자뒤집기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        int lt = 0;
        int rt = arr.length-1;

        while (lt<rt) {
            while (!Character.isAlphabetic(arr[lt])) {
                lt++;
            }
            while (!Character.isAlphabetic(arr[rt])) {
                rt--;
            }
            char tmp = arr[lt];
            arr[lt] = arr[rt];
            arr[rt] = tmp;

            lt++;
            rt--;
        }

        System.out.println(String.valueOf(arr));
    }
}
