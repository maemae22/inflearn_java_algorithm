package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P02_괄호문자제거 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        for (char c : arr) {
            if (c=='(') {
                stack.push(c);
            } else if (c==')') {
                stack.pop();
            } else if (stack.isEmpty()) {
                System.out.print(c);
            }
        }
    }
}
