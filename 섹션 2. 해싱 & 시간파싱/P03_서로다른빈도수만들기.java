import java.util.*;

public class P03_서로다른빈도수만들기 {
    public int solution(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        HashSet<Integer> set = new HashSet<>();
        int answer = 0;
        for (int tmp : map.values()) {
            if (!set.contains(tmp)) {
                set.add(tmp);
            } else {
                int count = 1;
                while (set.contains(tmp-count) && tmp-count>0) {
                    count++;
                }
                set.add(tmp-count);
                answer += count;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        P03_서로다른빈도수만들기 T = new P03_서로다른빈도수만들기();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}
