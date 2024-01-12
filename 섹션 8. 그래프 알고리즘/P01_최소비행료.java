import java.util.*;

public class P01_최소비행료 {
    public int solution(int n, int[][] flights, int s, int e, int k) {
        List<ArrayList<int[]>> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] tmp : flights) {
            list.get(tmp[0]).add(new int[]{tmp[1], tmp[2]});
        }

        int answer = Integer.MAX_VALUE;
        int L = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{s, 0});

        while (L<=k+1 && !q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int[] now = q.poll();
                if (now[0]==e) {
                    answer = Math.min(answer, now[1]);
                }
                for (int[] nx : list.get(now[0])) {
                    q.offer(new int[]{nx[0], now[1]+nx[1]});
                }
            }
            L++;
        }

        return answer==Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args) {
        P01_최소비행료 T = new P01_최소비행료();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
        System.out.println(T.solution(4, new int[][]{{0, 3, 59},{2, 0, 83}, {3, 1, 16}, {1, 3, 16}}, 3, 0, 3));
    }
}
