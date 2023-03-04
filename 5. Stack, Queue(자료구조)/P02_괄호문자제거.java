import java.util.*;
import java.io.*;

// 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
// ex. (A(BC)D)EF(G(H)(IJ)K)LM(N) -> EFLM
public class P02_괄호문자제거 {
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
}
