import java.util.*;
import java.io.*;

// 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
// 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
// ex. a#b!GE*T@S -> S#T!EG*b@a
public class P05_특정문자뒤집기 {

    // 방법 1.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] letter = br.readLine().toCharArray();

        int lt = 0;
        int rt = letter.length - 1;

        while(lt < rt) {
            while (true) {
                if (isEnglish(letter[lt])) {
                    break;
                } else {
                    lt++;
                }
            }
            while (true) {
                if (isEnglish(letter[rt])) {
                    break;
                } else {
                    rt--;
                }
            }
            char tmp = letter[lt];
            letter[lt] = letter[rt];
            letter[rt] = tmp;

            lt++;
            rt--;
        }

        String answer = String.valueOf(letter);
        System.out.println(answer);
    }

    public static boolean isEnglish(char c) {
        if((65 <= c && c<=90) || (97<=c && c<= 122)) {
            return true;
        } else {
            return false;
        }
    }

    // 방법2. Character.isAlphabetic(c) 사용 ! 알파벳인지 아닌지 알려줌
    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] letter = br.readLine().toCharArray();

        int lt = 0;
        int rt = letter.length - 1;

        while(lt < rt) {

            if (!Character.isAlphabetic(letter[lt])) { // letter[lt]가 특수문자이면,
                lt++;
            } else if (!Character.isAlphabetic(letter[rt])) { // letter[rt]가 특수문자이면,
                rt--;
            } else { // letter[lt]와 letter[rt]가 모두 영문자일 경우에,
                // 서로 바꿔준다
                char tmp = letter[lt];
                letter[lt] = letter[rt];
                letter[rt] = tmp;

                lt++;
                rt--;
            }
        }

        String answer = String.valueOf(letter);
        System.out.println(answer);
    }

}
