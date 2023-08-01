import java.util.*;

public class P04_팰린드롬의경우수 {

    static List<String> answers;
    static HashMap<Character, Integer> map;
    static char oneChar;
    static int total;

    public String[] solution(String s) {

        answers = new ArrayList<>();
        map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int one = 0;
        oneChar = ' ';
        for (char c : map.keySet()) {
            if (map.get(c)%2!=0) {
                one++;
                oneChar = c;
            }
        }

        total = 0;
        if (one>1) {
            return new String[0];
        } else if (one==1) {
            for (char c : map.keySet()) {
                if (c==oneChar) {
                    map.put(c, (map.get(c)-1)/2);
                } else {
                    map.put(c, map.get(c)/2);
                }
                total += map.get(c);
            }
        } else {
            for (char c : map.keySet()) {
                map.put(c, map.get(c)/2);
                total += map.get(c);
            }
        }

        DFS(0, "");

        String[] answer = new String[answers.size()];
        for (int i=0; i<answers.size(); i++) {
            answer[i] = answers.get(i);
        }

        return answer;
    }

    public static void DFS(int count, String now) {
        if (count==total) {
            String one = now;
            String reverse = new StringBuilder(now).reverse().toString();
            if (oneChar==' ') {
                answers.add(one+reverse);
            } else {
                answers.add(one+oneChar+reverse);
            }
        } else {
            for (char c : map.keySet()) {
                if (map.get(c)>0) {
                    map.put(c, map.get(c)-1);
                    DFS(count+1, now+c);
                    map.put(c, map.get(c)+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        P04_팰린드롬의경우수 T = new P04_팰린드롬의경우수();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
}
