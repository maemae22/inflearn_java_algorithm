import java.util.*;

public class P02_겹쳐진압축해제 {

    public String solution(String s) {

        Stack<String> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)!=')') {
                stack.add(String.valueOf(s.charAt(i)));
            } else {
                String tmp = "";
                while (!stack.peek().equals("(")) {
                    tmp = stack.pop() + tmp;
                }
                stack.pop(); // ( 제거
                String num = "";
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    num = stack.pop() + num;
                }

                if (num.equals("")) {
                    stack.add(tmp);
                } else {
                    int count = Integer.parseInt(num);
                    stack.add(repeatString(count, tmp));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String tmp : stack) {
            sb.append(tmp);
        }
        return sb.toString();
    }

    public String repeatString(int count, String tmp) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<count; i++) {
            sb.append(tmp);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        P02_겹쳐진압축해제 T = new P02_겹쳐진압축해제();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }
}
