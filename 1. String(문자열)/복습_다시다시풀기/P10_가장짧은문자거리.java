package 복습_다시다시풀기;

import java.util.*;
import java.io.*;

public class P10_가장짧은문자거리 {

    public static void main(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String letter = st.nextToken();
        char c = st.nextToken().charAt(0);

        // 로직
        int[] answer = new int[letter.length()];
        int length = 10000;

        // 왼쪽의 타겟 문자로부터의 거리 구하기
        for (int i=0; i<letter.length(); i++) {
            if (c == letter.charAt(i)) {
                length = 0;
            }
            answer[i] = length;
            length++;
        }

        // 오른쪽 타겟 문자로부터의 거리 구하기
        length = 10000;
        for (int i=letter.length()-1; i>=0; i--) {
            if (c == letter.charAt(i)) {
                length = 0;
            }
            answer[i] = Math.min(answer[i], length);
            length++;
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int tmp : answer) {
            sb.append(tmp).append(" ");
        }

        System.out.println(sb.toString());
    }
}
