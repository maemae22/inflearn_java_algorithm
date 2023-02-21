import java.util.*;
import java.io.*;

// 대문자는 소문자로, 소문자는 대문자로
public class P02_대소문자변환 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 문자열 아스키코드
        // 숫자는 48 ~ 57, 영문 대문자는 65 ~ 90, 영문 소문자는 97 ~ 122.
        // 영문 소문자에서 32를 빼면 영문 대문자가 된다.
        for (char c : letter.toCharArray()) {
            if (65 <= c && c<=90) {
                bw.write((char)(c+32));
            } else {
                bw.write((char)(c-32));
            }

            /*
            // 방법2. Character 클래스 이용
            if(Character.isLowerCase(c)) {
                bw.write(Character.toUpperCase(c));
            } else {
                bw.write(Character.toLowerCase(c));
            }
             */
        }

        bw.flush();
        bw.close();
    }
}
