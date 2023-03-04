import java.util.*;
import java.io.*;

/*
괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
(())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
첫 번째 줄에 YES, NO를 출력한다.
ex.
(()(()))(() -> NO
 */
public class P01_올바른괄호 {

    // 방법1. Stack 사용 X
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        int open = 0;
        int close = 0;

        for(char c : letter.toCharArray()) {
            if (c == '(') {
                open++;
            } else {
                close++;
            }
        }

        if ( open!=close || letter.charAt(0)==')' || letter.charAt(letter.length()-1)=='(' ) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }

    }

    // 방법2. Stack 사용
    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        String answer = "YES";
        Stack<Character> stack = new Stack<>();

        for (char c : letter.toCharArray()) {
            if (c=='(') {
                stack.push('(');
            } else { // ')'일 때
                if (stack.isEmpty()) {
                    answer = "NO";
                    break;
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            answer = "NO";
        }

        System.out.println(answer);

    }
}
