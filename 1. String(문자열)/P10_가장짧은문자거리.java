import java.util.*;
import java.io.*;

// 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
// ex. teachermode e -> 1 0 1 2 1 0 1 2 2 1 0
public class P10_가장짧은문자거리 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] letter = st.nextToken().toCharArray();
        int[] answer = new int[letter.length];
        char c = st.nextToken().charAt(0);
        int length = 1000;

        // 왼쪽->오른쪽 돌기. 왼쪽의 c로부터의 거리를 answer 배열에 넣는다.
        for (int i=0; i<letter.length; i++) {
            if (letter[i] == c) {
                length = 0;
            }
            answer[i] = length;
            length++;
        }

        // 오른쪽->왼쪽으로 돌기. 오른쪽의 c로부터의 거리를 구하는데,
        // answer 배열에 있는 값보다 작으면, answer 배열 값을 (더 작은 값으로=최소 거리로) 바꾼다.
        length = 1000;
        for(int i=letter.length-1; i>=0; i--) {
            if (letter[i] == c) {
                length = 0;
            }

            // 방법1.
            if (answer[i] > length) {
                answer[i] = length;
            }

            // 방법2.
//            answer[i] = Math.min(answer[i], length);

            length++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<answer.length; i++) {
            sb.append(answer[i] + " ");
        }

        System.out.println(sb.toString());
    }
}
