import java.util.*;
import java.io.*;

// 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 주어졌을 때, 잘려진 쇠막대기 조각의 총 개수를 구하는 프로그램을 작성하시오.
// ex1. ()(((()())(())()))(()) -> 17
// ex2. (((()(()()))(())()))(()()) -> 24
public class P05_쇠막대기 {

    // 방법1.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        Stack<Character> stack = new Stack<>();
        int count = 0;
        int close = 0;

        for (int i=0; i<letter.length(); i++) {
            char c = letter.charAt(i);

            if (c=='(') {
                stack.push(c);
            } else if (c==')' && letter.charAt(i-1) == '(') { // 레이저인 경우
                stack.pop();
                count += stack.size();
                while(close!=0) {
                    stack.pop();
                    close--;
                }
            } else { // 그냥 닫는 괄호인 경우
                close++;
            }
        }

        count += stack.size();

        System.out.println(count);
    }

    // 방법2.
    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (int i=0; i<letter.length(); i++) {
            char c = letter.charAt(i);

            if (c=='(') {
                stack.push(c);
            } else if (c==')' && letter.charAt(i-1) == '(') { // 레이저인 경우
                stack.pop();
                count += stack.size();
            } else { // 그냥 닫는 괄호인 경우
                stack.pop();
                count++;
            }
        }

        System.out.println(count);
    }
}
