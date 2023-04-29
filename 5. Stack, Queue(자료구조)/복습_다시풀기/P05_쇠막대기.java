package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P05_쇠막대기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for (int i=0; i<letter.length(); i++) {
            char c = letter.charAt(i);
            if (c=='(') {
                stack.push(c);
            } else {
                if (letter.charAt(i-1)=='(') { // 레이저인 경우
                    stack.pop();
                    answer += stack.size();
                } else { // 막대기의 끝인 경우
                    stack.pop();
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
