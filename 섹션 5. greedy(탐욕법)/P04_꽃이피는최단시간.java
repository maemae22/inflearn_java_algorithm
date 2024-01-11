import java.util.*;

public class P04_꽃이피는최단시간 {
    public int solution(int[] plantTime, int[] growTime) {
        List<Plant> list = new ArrayList<>();
        for (int i=0; i<plantTime.length; i++) {
            list.add(new Plant(plantTime[i], growTime[i]));
        }

        Collections.sort(list);
        int plant = 0;
        int answer = 0;
        for (Plant tmp : list) {
            plant += tmp.seed;
            answer = Math.max(answer, plant+tmp.grow);
        }

        return answer;
    }

    public static void main(String[] args) {
        P04_꽃이피는최단시간 T = new P04_꽃이피는최단시간();
        System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
        System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
        System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
        System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
    }
}

class Plant implements Comparable<Plant> {
    int seed;
    int grow;
    Plant(int seed, int grow) {
        this.seed = seed;
        this.grow = grow;
    }
    @Override
    public int compareTo(Plant o) {
        return o.grow - this.grow;
    }
}
