package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P04_단어뒤집기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            String letter = br.readLine();
            StringBuilder sb = new StringBuilder();
            sb.append(letter).reverse();
            System.out.println(sb.toString());
        }
    }

    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            String letter = br.readLine();
            String answer = "";
            for (int j=1; j<=letter.length(); j++) {
                answer += letter.charAt(letter.length()-j);
            }
            System.out.println(answer);
        }
    }
}
