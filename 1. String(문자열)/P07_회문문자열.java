import java.util.*;
import java.io.*;

// 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
// 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
// 단 회문을 검사할 때 대소문자를 구분하지 않습니다.
// ex. gooG -> YES
public class P07_회문문자열 {

    // 방법1.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine().toUpperCase();
        String newLetter = "";

        for (int i=0; i<letter.length(); i++) {
            newLetter = letter.charAt(i) + newLetter;
        }

        if (newLetter.equals(letter)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    // 방법2.
    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine().toUpperCase();

        int lt = 0;
        int rt = letter.length() - 1;
        boolean result = true;

        while(lt < rt) {
            if (letter.charAt(lt) == letter.charAt(rt)) {
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
}
