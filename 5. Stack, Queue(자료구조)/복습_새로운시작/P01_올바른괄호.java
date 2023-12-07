package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P01_올바른괄호 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] letter = br.readLine().toCharArray();

        String answer = "YES";
        if (letter[0]==')') {
            answer = "NO";
        } else {
            Stack<Character> stack = new Stack<>();
            for (char c : letter) {
                if (c=='(') {
                    stack.push('(');
                } else { // c==')'
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
        }

        System.out.println(answer);
    }
}
