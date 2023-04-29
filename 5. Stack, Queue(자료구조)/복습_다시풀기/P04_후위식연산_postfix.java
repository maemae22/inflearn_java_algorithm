package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P04_후위식연산_postfix {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        Stack<Integer> stack = new Stack<>();
        for (char c : letter.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(Integer.parseInt(String.valueOf(c)));
            } else {
                if (stack.size()>1) {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(calculate(c, a, b));
                }
            }
        }

        System.out.println(stack.pop());
    }

    public static int calculate(char c, int a, int b) {
        if (c=='+') {
            return a+b;
        } else if (c=='-') {
            return a-b;
        } else if (c=='*') {
            return a*b;
        } else {
            return a/b;
        }
    }
}
