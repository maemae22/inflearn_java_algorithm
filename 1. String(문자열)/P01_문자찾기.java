import java.util.*;
import java.io.*;

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

        System.out.println(count);
    }
}
