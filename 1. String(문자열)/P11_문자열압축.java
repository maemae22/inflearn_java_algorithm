import java.util.*;
import java.io.*;

// 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
// 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
// 단 반복횟수가 1인 경우 생략합니다.
// ex1. KKHSSSSSSSE -> K2HS7E
// ex2. KSTTTSEEKFKKKDJJGG -> KST3SE2KFK3DJ2G2
public class P11_문자열압축 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        // ⭐ 이렇게 하면 안됨. char 가 아니라 String형이 와야 StringBuilder 안에 들어간다.
        // StringBuilder sb = new StringBuilder(letter.charAt(0));
        StringBuilder sb = new StringBuilder(String.valueOf(letter.charAt(0)));

        int count = 1;

        for (int i=1; i<letter.length(); i++) {
            if (letter.charAt(i) != letter.charAt(i-1)) {
                if (count!=1) {
                    sb.append(count);
                }
                sb.append(letter.charAt(i));
                count = 1;
            } else {
                count++;
            }
        }

        if (count!=1) {
            sb.append(count);
        }

        System.out.println(sb.toString());
    }
}
