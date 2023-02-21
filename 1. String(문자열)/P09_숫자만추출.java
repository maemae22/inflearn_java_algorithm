import java.util.*;
import java.io.*;

// 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
// 만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.
// 추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.
// ex. g0en2T0s8eSoft -> 208
public class P09_숫자만추출 {

    // 방법1. replaceAll 사용
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();
        String number = letter.replaceAll("[^0-9]", "");
        int index = 0;

        for (int i=0; i<number.length(); i++) {
            if (number.charAt(i) != '0') {
                index = i;
                break;
            }
        }

        String answer = number.substring(index);
        System.out.println(answer);
    }

    // 방법2. 아스키코드 사용 (숫자는 48 ~ 57, 영문 대문자는 65 ~ 90, 영문 소문자는 97 ~ 122.)
    // answer = answer * 10 + (x-48)
    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        int answer = 0;
        for (char c : letter.toCharArray()) {
            if (48<=c && c<=57) {
                answer = answer*10 + (c-48);
            }
        }

        System.out.println(answer);
    }

    // 방법3. Character.isDigit(c), Integer.parseInt(answer) 사용
    public static void main3(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();

        String answer = "";

        for (char c : letter.toCharArray()) {
            if (Character.isDigit(c)) { // Character.isDigit(c) : char가 숫자인지 판별
                answer += c; // 숫자만 추출 (ex. 0208)
            }
        }

        System.out.println(Integer.parseInt(answer)); // Integer.parseInt(answer) : 숫자로 변환 (ex. 0208 -> 208)
    }
}
