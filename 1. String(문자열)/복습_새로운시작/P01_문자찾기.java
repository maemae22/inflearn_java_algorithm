package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P01_문자찾기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine().toUpperCase();
        char c = br.readLine().toUpperCase().charAt(0);

        int answer = 0;
        for (char tmp : letter.toCharArray()) {
            if (tmp==c) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
