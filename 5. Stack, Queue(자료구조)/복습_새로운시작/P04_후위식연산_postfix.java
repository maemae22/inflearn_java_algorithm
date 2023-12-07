package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P04_후위식연산_postfix {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] cal = br.readLine().toCharArray();

        Stack<Double> stack = new Stack<>();
        for (char c : cal) {
            if (Character.isDigit(c)) {
                stack.push((double)(c-'0'));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                if (c=='+') {
                    stack.push(a+b);
                } else if (c=='-') {
                    stack.push(a-b);
                } else if (c=='/') {
                    stack.push(a/b);
                } else if (c=='*') {
                    stack.push(a*b);
                }
            }
        }

        int answer = (int)(double)stack.pop();
        System.out.println(answer);
    }
}
