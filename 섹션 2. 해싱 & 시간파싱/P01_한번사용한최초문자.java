import java.util.*;

public class P01_한번사용한최초문자 {
    public int solution(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.remove(c);
            } else {
                map.put(c, i+1);
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int tmp : map.values()) {
            answer = Math.min(tmp, answer);
        }

        return answer==Integer.MAX_VALUE? -1 : answer;
    }

    public int solution2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for (int i=0; i<s.length(); i++) {
            if (map.get(s.charAt(i))==1) {
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        P01_한번사용한최초문자 T = new P01_한번사용한최초문자();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
        System.out.println();
        System.out.println(T.solution2("statitsics"));
        System.out.println(T.solution2("aabb"));
        System.out.println(T.solution2("stringshowtime"));
        System.out.println(T.solution2("abcdeabcdfg"));
    }
}
