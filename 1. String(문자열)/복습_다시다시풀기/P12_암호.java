package 복습_다시다시풀기;

import java.util.*;
import java.io.*;

public class P12_암호 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String letter = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            String tmp = letter.substring(i*7, i*7+7);
            String twoNum = tmp.replace("#", "1").replace("*", "0");
            int ten = Integer.parseInt(twoNum, 2);
            char c = (char)(ten);
            sb.append(c);
        }

        System.out.println(sb.toString());
    }
}
