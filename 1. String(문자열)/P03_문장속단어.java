import java.util.*;
import java.io.*;

// 문장이 주어지면, 문장 속에서 제일 긴 단어를 찾아서 return.
public class P03_문장속단어 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String answer = "";

        while(st.hasMoreTokens()) {
            String str = st.nextToken();
            if (str.length() > answer.length()) {
                answer = str;
            }
        }
        System.out.println(answer);
    }

    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String answer = "";
        int maxLength = Integer.MIN_VALUE; // Integer 값 중에서 가장 작은 수 (-2147483648)

        String[] arr = str.split(" ");
        for (String word : arr) {
            int length = word.length();
            if (length > maxLength) {
                maxLength = length;
                answer = word;
            }
        }

        System.out.println(answer);
    }

    public static void main3(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String answer = "";
        int maxLength = Integer.MIN_VALUE; // Integer 값 중에서 가장 작은 수 (-2147483648)
        int pos = 0;

        while( (pos=str.indexOf(' ')) != -1) {
            String tmp = str.substring(0, pos);
            int length = tmp.length();

            if (length > maxLength) {
                maxLength = length;
                answer = tmp;
            }

            str = str.substring(pos+1);
        }

        if (str.length() > maxLength) {
            answer = str;
        }

        System.out.println(answer);
    }
}
