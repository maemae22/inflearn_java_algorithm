package 복습_다시다시풀기;

import java.util.*;
import java.io.*;

public class P01_문자찾기 {

    public static void main(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine().toUpperCase();
        char c = br.readLine().toUpperCase().charAt(0);

        // 로직
        int answer = 0;
        for (char one : letter.toCharArray()) {
            if (c == one) {
                answer++;
            }
        }

        // 출력
        System.out.println(answer);
    }
}
