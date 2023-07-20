import java.util.*;

public class P02_같은빈도수만들기 {
    public int[] solution(String s) {
        int[] count = new int[5];
        for (char c : s.toCharArray()) {
            count[(int)c-'a']++;
        }

        int max = 0;
        for (int tmp : count) {
            max = Math.max(max, tmp);
        }

        int[] answer = new int[5];
        for (int i=0; i<5; i++) {
            answer[i] = max - count[i];
        }

        return answer;
    }

    public static void main(String[] args){
        P02_같은빈도수만들기 T = new P02_같은빈도수만들기();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
