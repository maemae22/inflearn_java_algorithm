import java.util.*;

public class P06_교육과정 {
    public String[] solution(String[] subjects, String[] course) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i=0; i<subjects.length; i++) {
            map.put(subjects[i], i);
            list.add(new ArrayList<>());
        }
        int[] input = new int[subjects.length];
        for (String tmp : course) {
            StringTokenizer st = new StringTokenizer(tmp);
            int two = map.get(st.nextToken());
            int one = map.get(st.nextToken());
            list.get(one).add(two);
            input[two]++;
        }

        List<Integer> order = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<input.length; i++) {
            if (input[i]==0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int tmp = q.poll();
            order.add(tmp);
            for (int next : list.get(tmp)) {
                input[next]--;
                if (input[next]==0) {
                    q.offer(next);
                }
            }
        }

        String[] answer = new String[input.length];
        for (int i=0; i<answer.length; i++) {
            answer[i]=subjects[order.get(i)];
        }

        return answer;
    }

    public static void main(String[] args) {
        P06_교육과정 T = new P06_교육과정();
        System.out.println(Arrays.toString(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"})));
    }
}
