import java.util.*;

public class P07_최소회의실개수 {
    public int solution(int[][] meetings) {
        int[] in = new int[meetings.length];
        int[] out = new int[meetings.length];
        for (int i=0; i<meetings.length; i++) {
            in[i] = meetings[i][0];
            out[i] = meetings[i][1];
        }

        Arrays.sort(in);
        Arrays.sort(out);

        int answer = -1;
        int outIndex = 0;
        int now = 0;
        for (int i=0; i<in.length; i++) {
            while (out[outIndex]<=in[i]) {
                outIndex++;
                now--;
            }
            now++;
            answer = Math.max(answer, now);
        }

        return answer;
    }

    public int solution2(int[][] meetings) {
        List<Time> list = new ArrayList<>();
        for (int i=0; i<meetings.length; i++) {
            Time time1 = new Time(meetings[i][0], 1);
            Time time2 = new Time(meetings[i][1], 2);
            list.add(time1);
            list.add(time2);
        }

        Collections.sort(list);

        int answer = -1;
        int now = 0;
        for (Time tmp : list) {
            if (tmp.inout==1) {
                now++;
            } else {
                now--;
            }
            answer = Math.max(answer, now);
        }

        return answer;
    }

    public static void main(String[] args) {
        P07_최소회의실개수 T = new P07_최소회의실개수();
        System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
        System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println();
        System.out.println("2번째 풀이");
        System.out.println(T.solution2(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
        System.out.println(T.solution2(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution2(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution2(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}

class Time implements Comparable<Time> {
    int time;
    int inout;
    Time(int time, int inout) {
        this.time = time;
        this.inout = inout;
    }

    @Override
    public int compareTo(Time o) {
        // 정렬 방법
        // 1. 시간(time)을 기준으로 오름차순 정렬한다.
        // 2. 시간이 같을 경우, inout을 기준으로 내림차순 정렬한다.
        //    (in=1, out=2 인데 out이 먼저 카운트되어야 하기 때문에 out(2)->in(1) 내림차순 정렬 필요)
        return this.time==o.time ? o.inout-this.inout : this.time-o.time;
    }
}
