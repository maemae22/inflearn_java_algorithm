package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P01_올바른괄호 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        Stack<Character> stack = new Stack<>();
        String answer = "YES";
        for (char c : letter.toCharArray()) {
            if (c=='(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    answer = "NO";
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty()) {
            answer = "NO";
        }

        System.out.println(answer);
    }
}
