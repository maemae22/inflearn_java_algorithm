package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P04_단어뒤집기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.setLength(0);
            sb.append(br.readLine());
            System.out.println(sb.reverse().toString());
        }
    }
}
