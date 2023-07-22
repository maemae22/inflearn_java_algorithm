import java.util.*;

public class P07_경고메일 {
    public String[] solution(String[] reports, int limit) {
        HashMap<String, Integer> in = new HashMap<>();
        HashMap<String, Integer> total = new HashMap<>();

        for (String tmp : reports) {
            StringTokenizer st = new StringTokenizer(tmp);
            String name = st.nextToken();
            int time = timeToMinute(st.nextToken());
            String status = st.nextToken();
            if (status.equals("in")) {
                in.put(name, time);
            } else {
                total.put(name, total.getOrDefault(name, 0)+time-in.get(name));
            }
        }

        List<String> names = new ArrayList<>();
        for (String name : total.keySet()) {
            if (total.get(name)>limit) {
                names.add(name);
            }
        }

        Collections.sort(names);
        String[] answer = new String[names.size()];
        for (int i=0; i<names.size(); i++) {
            answer[i] = names.get(i);
        }

        return answer;
    }

    public int timeToMinute(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3));
        return hour*60+minute;
    }

    public static void main(String[] args) {
        P07_경고메일 T = new P07_경고메일();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}