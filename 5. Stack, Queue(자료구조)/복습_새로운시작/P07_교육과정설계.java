package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P07_교육과정설계 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] must = br.readLine().toCharArray();
        char[] test = br.readLine().toCharArray();

        Queue<Character> q = new LinkedList<>();
        for (char c : must) {
            q.offer(c);
        }

        for (char c : test) {
            if (c==q.peek()) {
                q.poll();
                if (q.isEmpty()) {
                    break;
                }
            }
        }

        if (q.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
