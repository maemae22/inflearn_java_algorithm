import java.util.*;

public class P05_회장선거 {
    public String solution(String[] votes, int k) {
        String[] from = new String[votes.length];
        String[] to = new String[votes.length];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<votes.length; i++) {
            StringTokenizer st = new StringTokenizer(votes[i]);
            from[i] = st.nextToken();
            to[i] = st.nextToken();
            map.put(to[i], map.getOrDefault(to[i], 0)+1);
        }

        HashSet<String> nominate = new HashSet<>();
        for (String name : map.keySet()) {
            if (map.get(name)>=k) {
                nominate.add(name);
            }
        }

        int max = 0;
        HashMap<String, Integer> present = new HashMap<>();
        for (int i=0; i<votes.length; i++) {
            if (nominate.contains(to[i])) {
                int num = present.getOrDefault(from[i], 0)+1;
                present.put(from[i], num);
                max = Math.max(max, num);
            }
        }

        List<String> answers = new ArrayList<>();
        for (String name : present.keySet()) {
            if (max == present.get(name)) {
                answers.add(name);
            }
        }

        Collections.sort(answers);
        return answers.get(0);
    }

    public static void main(String[] args){
        P05_회장선거 T = new P05_회장선거();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}