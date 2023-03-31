package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P09_숫자만추출 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();
        String num = letter.replaceAll("[^0-9]", "");
        int answer = Integer.parseInt(num);
        System.out.println(answer);
    }
}
