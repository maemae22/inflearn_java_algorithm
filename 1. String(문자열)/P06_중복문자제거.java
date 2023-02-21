import java.util.*;
import java.io.*;

// 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
// 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
// ex. ksekkset -> kset
public class P06_중복문자제거 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();
        String answer = "";

        for(int i=0; i<letter.length(); i++) {
            // 방법 1. indexOf() 사용 (없을 경우 -1 반환함)
            if (answer.indexOf(letter.charAt(i)) == -1) {
                answer += letter.charAt(i);
            }

            /*
            // 방법2. contains() 사용 (참고 : contains는 공백도 체크함)
            if (!answer.contains(String.valueOf(letter.charAt(i)))) {
                answer += letter.charAt(i);
            }
             */
        }

        System.out.println(answer);
    }
}
