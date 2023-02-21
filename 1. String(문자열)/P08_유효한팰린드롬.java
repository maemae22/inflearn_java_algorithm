import java.util.*;
import java.io.*;

// 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
// 문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
// 단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
// 알파벳 이외의 문자들의 무시합니다.
// ex. found7, time: study; Yduts; emit, 7Dnuof -> YES
public class P08_유효한팰린드롬 {

    // 방법1. Character.isAlphabetic(c) 사용
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine().toUpperCase();
        String realLetter = "";

        // 알파벳만 가져오기
        for (int i=0; i<letter.length(); i++) {
            if (Character.isAlphabetic(letter.charAt(i))) {
                realLetter += letter.charAt(i);
            }
        }

        // 팰린드롬(회문) 검사하기
        int lt = 0;
        int rt = realLetter.length() -1;
        boolean result = true;

        while(lt < rt) {
            if (realLetter.charAt(lt) == realLetter.charAt(rt)) {
                lt++;
                rt--;
            } else {
                System.out.println("NO");
                result = false;
                break;
            }
        }

        if (result) {
            System.out.println("YES");
        }
    }

    // 방법2. replaceAll 정규식 이용
    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine().toUpperCase().replaceAll("[^A-Z]", "");
        String answer = "NO";

        String reverse = new StringBuilder(letter).reverse().toString();

        if (letter.equals(reverse)) {
            answer = "YES";
        }

        System.out.println(answer);
    }
}
