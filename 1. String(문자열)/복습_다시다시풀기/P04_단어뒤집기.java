package 복습_다시다시풀기;

import java.util.*;
import java.io.*;

public class P04_단어뒤집기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(br.readLine());
            String answer = sb.reverse().toString();

            System.out.println(answer);
        }
    }
}
