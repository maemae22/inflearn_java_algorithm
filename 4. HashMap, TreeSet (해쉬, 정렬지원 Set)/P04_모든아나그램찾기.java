import java.util.*;
import java.io.*;

/*
S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
ex.
bacaAacba
abc
-> 3 (출력설명: {bac}, {acb}, {cba} 3개의 부분문자열이 "abc" 문자열과 아나그램입니다.)
 */
public class P04_모든아나그램찾기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        char[] firsts = first.toCharArray();
        String second = br.readLine();
        char[] seconds = second.toCharArray();

        HashMap<Character, Integer> firstMap = new HashMap<>();
        HashMap<Character, Integer> secondMap = new HashMap<>();

        for (int i=0; i<second.length()-1; i++) {
            firstMap.put(firsts[i], firstMap.getOrDefault(firsts[i], 0)+1 );
        }

        for (int i=0; i<seconds.length; i++) {
            secondMap.put(seconds[i], secondMap.getOrDefault(seconds[i], 0)+1 );
        }

        int answer = 0;
        int lt = 0;
        int rt = 0;
        for (rt=second.length()-1; rt<first.length(); rt++) {
            firstMap.put(firsts[rt], firstMap.getOrDefault(firsts[rt], 0)+1 );

            // 아나그램인지 비교
            boolean ok = true;
            for (char c : firstMap.keySet()) {
                if (firstMap.get(c) != secondMap.get(c)) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                answer++;
            }

            // lt 제거 및 lt 증가
            firstMap.put(firsts[lt], firstMap.get(firsts[lt])-1 );
            if (firstMap.get(firsts[lt]) == 0) {
                firstMap.remove(firsts[lt]);
            }
            lt++;
        }

        System.out.println(answer);
    }
}
