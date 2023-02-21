import java.util.*;
import java.io.*;

// 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
// 대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.
public class P01_문자찾기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine().toUpperCase();
        char c = br.readLine().toUpperCase().charAt(0);

        int count = 0;
        for (int i=0; i<letter.length(); i++) {
            if (c == letter.charAt(i)) {
                count++;
            }
        }

        /*
        // 방법2. 향상된 for문
        for( char oneChar : letter.toCharArray()) {
            if (c == oneChar) {
                count++;
            }
        }
         */

        System.out.println(count);
    }
}
