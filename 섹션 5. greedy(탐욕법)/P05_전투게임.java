import java.util.*;

public class P05_전투게임 {
    public int[] solution(String[] students) {
        int[] answer = new int[students.length];
        List<Game> list = new ArrayList<>();
        for (int i=0; i<students.length; i++) {
            StringTokenizer st = new StringTokenizer(students[i]);
            char team = st.nextToken().charAt(0);
            int power = Integer.parseInt(st.nextToken());
            list.add(new Game(i, team, power));
        }

        Collections.sort(list);
        int[] teamsSum = new int[26];
        int sum = 0;

        for (int i=0; i<list.size(); i++) {
            Game tmp = list.get(i);
            answer[tmp.index] = sum - teamsSum[tmp.team-97];
            sum += tmp.power;
            teamsSum[tmp.team-97] += tmp.power;

            int pri = i-1;
            int count = 0;
            while (0<=pri && tmp.power==list.get(pri).power) {
                if (list.get(pri).team!=tmp.team) {
                    count++;
                }
                pri--;
            }
            answer[tmp.index] -= tmp.power*(count);
        }

        return answer;
    }

    public int[] solution2(String[] students) {
        int[] answer = new int[students.length];
        List<Game> list = new ArrayList<>();
        for (int i=0; i<students.length; i++) {
            StringTokenizer st = new StringTokenizer(students[i]);
            char team = st.nextToken().charAt(0);
            int power = Integer.parseInt(st.nextToken());
            list.add(new Game(i, team, power));
        }

        Collections.sort(list);
        HashMap<Character, Integer> map = new HashMap<>();
        int sum = 0;
        int j=0;
        for (int i=0; i<list.size(); i++) {
            for ( ; list.get(j).power<list.get(i).power; j++) {
                sum += list.get(j).power;
                map.put(list.get(j).team, map.getOrDefault(list.get(j).team, 0)+list.get(j).power);
            }
            answer[list.get(i).index] = sum - map.getOrDefault(list.get(i).team, 0);
        }

        return answer;
    }

    public static void main(String[] args) {
        P05_전투게임 T = new P05_전투게임();
        System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
        System.out.println();
        System.out.println(Arrays.toString(T.solution2(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution2(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution2(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution2(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }
}

class Game implements Comparable<Game> {
    int index;
    char team;
    int power;
    Game(int index, char team, int power) {
        this.index = index;
        this.team = team;
        this.power = power;
    }
    @Override
    public int compareTo(Game o) {
        return this.power-o.power;
    }
}
