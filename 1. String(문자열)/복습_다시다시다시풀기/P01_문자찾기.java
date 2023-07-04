package 복습_다시다시다시풀기;

import java.util.*;
import java.io.*;

public class P01_문자찾기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine().toLowerCase();
        char c = br.readLine().toLowerCase().charAt(0);

        int answer = 0;
        for (char tmp : letter.toCharArray()) {
            if (tmp == c) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
