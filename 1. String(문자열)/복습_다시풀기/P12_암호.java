package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P12_암호 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String letter = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            String password = letter.substring(i*7, i*7+7);
            sb.append(solve(password));
        }

        System.out.println(sb.toString());
    }

    public static Character solve(String password) {
        String number = password.replace("#", "1").replace("*", "0");
        int ten = Integer.parseInt(number, 2);
        return (char)(ten);
    }
}
