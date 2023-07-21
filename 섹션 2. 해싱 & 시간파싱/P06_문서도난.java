import java.util.*;

public class P06_문서도난 {
    public String[] solution(String[] reports, String times) {
        StringTokenizer st = new StringTokenizer(times);
        int startTime = stringTimeToInt(st.nextToken());
        int endTime = stringTimeToInt(st.nextToken());

        List<Use> people = new ArrayList<>();
        for (String tmp : reports) {
            st = new StringTokenizer(tmp);
            String name = st.nextToken();
            int time = stringTimeToInt(st.nextToken());
            if (startTime<=time && time<=endTime) {
                people.add(new Use(name, time));
            }
        }

        Collections.sort(people);
        String[] answer = new String[people.size()];
        for (int i=0; i<people.size(); i++) {
            answer[i] = people.get(i).name;
        }

        return answer;
    }

    public int stringTimeToInt(String time) {
        return Integer.parseInt(time.substring(0, 2)+time.substring(3));
    }

    public static void main(String[] args){
        P06_문서도난 T = new P06_문서도난();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}

class Use implements Comparable<Use> {
    String name;
    int time;
    Use(String name, int time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public int compareTo(Use o) {
        return this.time - o.time;
    }
}
