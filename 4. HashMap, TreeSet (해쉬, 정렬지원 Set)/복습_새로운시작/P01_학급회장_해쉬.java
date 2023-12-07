package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P01_학급회장_해쉬 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String vote = br.readLine();
        HashMap<Character, Integer> result = new HashMap<>();
        for (char c : vote.toCharArray()) {
            result.put(c, result.getOrDefault(c, 0)+1);
        }

        int max = 0;
        char answer = ' ';
        for (char c : result.keySet()) {
            if (max<result.get(c)) {
                max = result.get(c);
                answer = c;
            }
        }

        System.out.println(answer);
    }
}
