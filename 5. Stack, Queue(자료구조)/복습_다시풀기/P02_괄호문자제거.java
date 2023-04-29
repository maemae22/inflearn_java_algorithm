package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P02_괄호문자제거 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (char c : letter.toCharArray()) {
            if (c==')') {
                while (stack.pop()!='(') {}
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.reverse().toString());
    }
}
