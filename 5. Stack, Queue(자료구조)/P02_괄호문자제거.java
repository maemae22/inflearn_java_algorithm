import java.util.*;
import java.io.*;

// 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
// ex. (A(BC)D)EF(G(H)(IJ)K)LM(N) -> EFLM
public class P02_괄호문자제거 {

    // 방법1. Stack (1)
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char c : letter.toCharArray()) {
            if (c=='(') {
                stack.push('(');
            } else if (c==')') {
                stack.pop();
            } else {
                if (stack.isEmpty()) {
                    sb.append(c);
                }
            }
        }

        System.out.println(sb.toString());
    }

    // 방법2. Stack (2) : Stack에 남아있는 값들을 출력 - stack.size() / stack.get() / 향상된 for문
    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (char c : letter.toCharArray()) {
            if (c==')') {
                while (stack.pop() != '('); // '('가 나올 때까지 stack에서 제거 (.pop())
            } else {
                stack.push(c);
            }
        }

        // stack에 남아있는 값들을 출력
        StringBuilder sb = new StringBuilder();
        // 방법2-1. for문 : stack.size() / stack.get(i)
        for (int i=0; i<stack.size(); i++) {
            sb.append(stack.get(i));
        }
        /*
        // 방법2-2. 향상된 for문
        for (char c : stack) {
            sb.append(c);
        }
         */

        System.out.println(sb.toString());
    }
}
