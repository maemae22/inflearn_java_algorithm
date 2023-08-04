import java.util.*;

public class P06_가장많이사용된회의실 {
    public int solution(int n, int[][] meetings) {
        int[] check = new int[n];
        int[] times = new int[n];
        PriorityQueue<Meet> meeting = new PriorityQueue<>();
        for (int[] meets : meetings) {
            meeting.add(new Meet(meets[0], meets[1]));
        }

        for (Meet tmp : meeting) {
            boolean find = false;
            int minFinish = Integer.MAX_VALUE;
            int room = -1;

            for (int i=0; i<n; i++) {
                if (times[i]<minFinish) {
                    minFinish=times[i];
                    room=i;
                }

                if (times[i]<=tmp.start) {
                    check[i]++;
                    times[i]=tmp.end;
                    find = true;
                    break;
                }
            }

            if (!find) {
                check[room]++;
                times[room]+=(tmp.end-tmp.start);
            }
        }

        int max = 0;
        int answer = -1;
        for (int i=0; i<n; i++) {
            if (check[i]>max) {
                max = check[i];
                answer = i;
            }
        }

        return answer;
    }

    public int solution2(int n, int[][] meetings) {
        int[] check = new int[n];
        PriorityQueue<Meet> meeting = new PriorityQueue<>();
        for (int[] meets : meetings) {
            meeting.add(new Meet(meets[0], meets[1]));
        }
        TreeSet<Integer> empty = new TreeSet<>();
        for (int i=0; i<n; i++) {
            empty.add(i);
        }
        PriorityQueue<Meet> now = new PriorityQueue<>();

        for (Meet tmp : meeting) {
            while (!now.isEmpty() && now.peek().start<=tmp.start) {
                Meet out = now.poll();
                empty.add(out.end);
            }
            if (!empty.isEmpty()) {
                int room = empty.pollFirst();
                check[room]++;
                now.add(new Meet(tmp.end, room));
            } else {
                Meet out = now.poll();
                check[out.end]++;
                now.add(new Meet(out.start+tmp.end-tmp.start, out.end));
            }
        }

        int max = 0;
        int answer = -1;
        for (int i=0; i<n; i++) {
            if (check[i]>max) {
                max = check[i];
                answer = i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P06_가장많이사용된회의실 T = new P06_가장많이사용된회의실();
        System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println();
        System.out.println(T.solution2(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution2(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution2(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution2(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    }
}

class Meet implements Comparable<Meet> {
    int start;
    int end;

    Meet(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meet o) {
        return this.start!=o.start ? this.start-o.start : this.end-o.end;
    }
}
