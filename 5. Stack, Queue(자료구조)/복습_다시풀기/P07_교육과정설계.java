package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P07_교육과정설계 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String must = br.readLine();
        String letter = br.readLine();
        Queue<Character> q = new LinkedList<>();
        for (char c : must.toCharArray()) {
            q.offer(c);
        }

        String answer = "YES";
        for (char c : letter.toCharArray()) {
            if (q.isEmpty()) {
                break;
            }

            if (must.contains(String.valueOf(c))) {
                if (q.poll()!=c) {
                    answer = "NO";
                    break;
                }
            }
        }

        if (!q.isEmpty()) {
            answer = "NO";
        }

        System.out.println(answer);
    }
}
