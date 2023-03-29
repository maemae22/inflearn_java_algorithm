package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P06_중복문자제거 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        int[] check = new int[30];
        StringBuilder sb = new StringBuilder();
        for (char c : letter.toCharArray()) {
            if (check[c-97]==0) {
                sb.append(c);
                check[c-97] = 1;
            }
        }

        System.out.println(sb.toString());
    }
}
