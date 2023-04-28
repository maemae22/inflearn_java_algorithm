package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P01_학급회장_해쉬 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String result = br.readLine();
        int[] arr = new int[5];
        for (int i=0; i<result.length(); i++) {
            arr[result.charAt(i)-65]++;
        }

        int maxIndex = -1;
        int max = 0;
        for (int i=0; i<5; i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }

        System.out.println((char)(maxIndex+65));
    }

    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String result = br.readLine();

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i=0; i<result.length(); i++) {
            map.put(result.charAt(i), map.getOrDefault(result.charAt(i), 0)+1);
        }

        int max = 0;
        char answer = ' ';

        for (char c : map.keySet()) {
            if (max < map.getOrDefault(c, 0)) {
                max = map.get(c);
                answer = c;
            }
        }

        System.out.println(answer);
    }
}
