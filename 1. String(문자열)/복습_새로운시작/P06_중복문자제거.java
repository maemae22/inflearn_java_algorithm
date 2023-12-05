package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P06_중복문자제거 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        String answer = "";
        HashSet<Character> set = new HashSet<>();

        for (char c : arr) {
            if (!set.contains(c)) {
                set.add(c);
                answer += c;
            }
        }

        System.out.println(answer);
    }
}
