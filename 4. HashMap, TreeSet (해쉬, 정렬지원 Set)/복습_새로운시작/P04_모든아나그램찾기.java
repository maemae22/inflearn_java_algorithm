package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P04_모든아나그램찾기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String big = br.readLine();
        String small = br.readLine();

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : small.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int ok = map.size();
        int now = 0;
        int answer = 0;

        for (char c : big.substring(0, small.length()).toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)-1);
                if (map.get(c)==0) {
                    now++;
                }
            }
        }

        if (now==ok) {
            answer++;
        }

        for (int i=small.length(); i<big.length(); i++) {
            char plus = big.charAt(i);
            char minus = big.charAt(i-small.length());

            if (plus!=minus) {
                if (map.containsKey(plus)) {
                    map.put(plus, map.get(plus)-1);
                    if (map.get(plus)==0) {
                        now++;
                    }
                }

                if (map.containsKey(minus)) {
                    if (map.get(minus)==0) {
                        now--;
                    }
                    map.put(minus, map.get(minus)+1);
                }
            }

            if (now==ok) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
