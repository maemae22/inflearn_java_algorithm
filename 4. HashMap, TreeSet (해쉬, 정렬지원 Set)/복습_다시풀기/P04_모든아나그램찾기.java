package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P04_모든아나그램찾기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();
        String small = br.readLine();
        int K = small.length();

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> smallMap = new HashMap<>();
        for (char c : small.toCharArray()) {
            smallMap.put(c, smallMap.getOrDefault(c, 0)+1);
        }

        int answer = 0;
        for (int i=0; i<small.length(); i++) {
            map.put(letter.charAt(i), map.getOrDefault(letter.charAt(i), 0)+1);
        }
        if (map.equals(smallMap)) {
            answer++;
        }

        for (int i=small.length(); i<letter.length(); i++) {
            map.put(letter.charAt(i), map.getOrDefault(letter.charAt(i), 0)+1);
            map.put(letter.charAt(i-K), map.get(letter.charAt(i-K))-1);

            boolean anagram = true;
            for (char c : smallMap.keySet()) {
                if (smallMap.get(c) != map.get(c)) {
                    anagram = false;
                    break;
                }
            }
            if (anagram) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
