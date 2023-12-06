package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P12_암호 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String letter = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            String tmp = letter.substring(i*7, (i+1)*7);
            tmp = tmp.replace("#", "1").replace("*", "0");
            int tenNum = Integer.parseInt(tmp, 2);
            sb.append((char)(tenNum));
        }

        System.out.println(sb.toString());
    }
}
