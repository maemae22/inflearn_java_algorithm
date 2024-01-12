import java.util.*;

public class P02_최소환승경로 {
    public int solution(int[][] routes, int s, int e) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i=0; i<=1000000; i++) {
            list.add(new ArrayList<>());
        }
        for (int i=0; i<routes.length; i++) {
            for (int j=0; j<routes[i].length; j++) {
                list.get(routes[i][j]).add(i);
            }
        }
        int[] end = new int[routes.length];
        for (int tmp : list.get(e)) {
            end[tmp]=1;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] check = new int[routes.length];
        for (int tmp : list.get(s)) {
            check[tmp]=1;
            q.add(tmp);
            if (end[tmp]==1) {
                return 0;
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int nowLine = q.poll();
                for (int station : routes[nowLine]) {
                    for (int nextLine : list.get(station)) {
                        if (end[nextLine]==1) {
                            return count+1;
                        }
                        if (check[nextLine]==0) {
                            check[nextLine]=1;
                            q.offer(nextLine);
                        }
                    }
                }
            }
            count++;
        }

        return -1;
    }

    public static void main(String[] args) {
        P02_최소환승경로 T = new P02_최소환승경로();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}
