import java.util.*;
import java.io.*;

// 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
// 만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
// 식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.
// ex. 352+*9- -> 12
public class P04_후위식연산_postfix {

    // 방법1. (방법2와 로직 자체는 동일)
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        Stack<Integer> stack = new Stack<>();

        for (char c : letter.toCharArray()) {

            if (isNumber(c)) { // c가 숫자면,
                stack.push(Integer.parseInt(String.valueOf(c)));
            } else { // c가 연산기호면,
                int second = stack.pop();
                int first = stack.pop();
                stack.push(calculate(first, second, c));
            }
        }

        System.out.println(stack.pop());
    }

    public static boolean isNumber(char c) {
        if (c!='+' && c!='-' && c!='*' && c!='/') { // c가 숫자면
            return true;
        } else {
            return false;
        }
    }

    public static int calculate(int a, int b, char c) {
        if (c=='+') {
            return a+b;
        } else if (c=='-') {
            return a-b;
        } else if (c=='*') {
            return a*b;
        } else { // c=='/'
            return a/b;
        }
    }

    // 방법2. Character.isDigit(c) / c-48 (아스키코드 활용) / stack.get(0)
    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        Stack<Integer> stack = new Stack<>();

        for (char c : letter.toCharArray()) {

            if (Character.isDigit(c)) { // c가 숫자면,
                stack.push(c-48);
            } else { // c가 연산기호면,
                int second = stack.pop();
                int first = stack.pop();
                if (c=='+') {
                    stack.push(first+second);
                } else if (c=='-') {
                    stack.push(first-second);
                } else if (c=='*') {
                    stack.push(first*second);
                } else { // c=='/'
                    stack.push(first/second);
                }
            }
        }

        System.out.println(stack.get(0));
    }
}
