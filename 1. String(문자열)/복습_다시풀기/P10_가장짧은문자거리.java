package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P10_가장짧은문자거리 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String letter = st.nextToken();
        char c = st.nextToken().charAt(0);

        int[] answer = new int[letter.length()];
        Arrays.fill(answer, Integer.MAX_VALUE);

        int length = 0;
        boolean find = false;
        for (int i=0; i<letter.length(); i++) {
            if (find) {
                answer[i] = Math.min(answer[i], length);
                length++;
            }
            if (letter.charAt(i) == c) {
                answer[i] = 0;
                find = true;
                length = 1;
            }
        }

        find = false;
        for (int i=letter.length()-1; i>=0; i--) {
            if (find) {
                answer[i] = Math.min(answer[i], length);
                length++;
            }
            if (letter.charAt(i) == c) {
                find = true;
                length = 1;
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int num : answer) {
            sb.append(num);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
