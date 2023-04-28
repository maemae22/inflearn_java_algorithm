package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P02_아나그램_해쉬 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : a.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for (char c : b.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)-1);
        }

        boolean anagram = true;
        for (char c : map.keySet()) {
            if (map.get(c)!=0) {
                anagram = false;
                break;
            }
        }

        if (anagram) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
