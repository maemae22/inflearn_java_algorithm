import java.util.*;

public class P06_가장많이사용된회의실 {
    public int solution(int n, int[][] meetings) {
        int[] check = new int[n];
        int[] times = new int[n];
        PriorityQueue<Meet> meeting = new PriorityQueue<>();
        for (int[] meets : meetings) {
            meeting.add(new Meet(meets[0], meets[1], meets[1]-meets[0]));
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
                    if (times[i]==tmp.start) {
                        times[i]+=tmp.time;
                    } else {
                        times[i]=tmp.end;
                    }
                    find = true;
                    break;
                }
            }

            if (!find) {
                check[room]++;
                times[room]+=tmp.time;
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
    }
}

class Meet implements Comparable<Meet> {
    int start;
    int end;
    int time;

    Meet(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }

    @Override
    public int compareTo(Meet o) {
        return this.start - o.start;
    }
}
