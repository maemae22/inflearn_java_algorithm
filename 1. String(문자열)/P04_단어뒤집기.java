import java.util.*;
import java.io.*;

public class P04_단어뒤집기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            String str = br.readLine();
            String answer = "";

            for (int k=0; k<str.length(); k++) {
                answer = str.charAt(k) + answer;
            }

            System.out.println(answer);
        }
    }

    // StringBuilder 이용
    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            String str = br.readLine();
            String answer = new StringBuilder(str).reverse().toString();
            System.out.println(answer);
        }
    }

    // 직접 뒤집기
    public static void main3(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            String str = br.readLine();
            char[] charArr = str.toCharArray();
            int lt = 0;
            int rt = charArr.length - 1;

            while(lt < rt) {
                char tmp = charArr[lt];
                charArr[lt] = charArr[rt];
                charArr[rt] = tmp;
                lt++;
                rt--;
            }

            String answer = String.valueOf(charArr);
            System.out.println(answer);
        }
    }
}
