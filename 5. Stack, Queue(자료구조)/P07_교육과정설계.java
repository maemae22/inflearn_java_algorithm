import java.util.*;
import java.io.*;

/*
필수과목순서가 주어지면 현수가 짠 수업설계가 잘된 것이면 “YES", 잘못된 것이면 ”NO“를 출력하는 프로그램을 작성하세요.
ex.
CBA
CBDAGE
-> YES
 */
public class P07_교육과정설계 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String vlftn = br.readLine();
        String letter = br.readLine();
        Queue<Character> queue = new LinkedList<>();
        for(char c : vlftn.toCharArray()) {
            queue.offer(c);
        }

        for (char c : letter.toCharArray()) {
            if (queue.isEmpty()) {
                break;
            }
            if (queue.peek() == c) {
                queue.poll();
            }
        }

        if (queue.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
