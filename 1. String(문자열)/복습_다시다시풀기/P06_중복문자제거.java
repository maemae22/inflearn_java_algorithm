package 복습_다시다시풀기;

import java.util.*;
import java.io.*;

public class P06_중복문자제거 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        String answer = "";

        for (char c : letter.toCharArray()) {
            if (answer.indexOf(c) == -1) {
                answer += c;
            }
        }

        System.out.println(answer);
    }
}
