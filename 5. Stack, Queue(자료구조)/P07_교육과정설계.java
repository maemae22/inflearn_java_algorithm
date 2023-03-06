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

        // 방법1.
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

        /*
        // 방법2.
        String answer = "YES";
        for (char c : letter.toCharArray()) {
            if (queue.contains(c)) { // 필수과목이면
                if (queue.poll() != c) { // Queue에서 꺼내고, 필수과목 순서가 맞는지 확인한다.
                    answer = "NO"; // 순서가 틀렸을 경우, NO로 답변을 바꾸고 break.
                    break;
                }
            }
        }

        // 계획대로 수업을 모두 수강했는데, 필수과목에 과목이 남아있을 경우 => 수강하지 않은 필수과목이 있다는 뜻
        if (!queue.isEmpty()) {
            answer = "NO";
        }

        System.out.println(answer);
         */

    }
}
