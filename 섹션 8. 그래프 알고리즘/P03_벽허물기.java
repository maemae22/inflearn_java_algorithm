import java.util.*;

public class P03_벽허물기 {
    public int solution(int[][] board) {
        int[][] count = new int[board.length][board[0].length];
        for (int[] tmp : count) {
            Arrays.fill(tmp, Integer.MAX_VALUE);
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int[] tmp = q.poll();
                for (int k=0; k<4; k++) {
                    int nx = tmp[0]+dx[k];
                    int ny = tmp[1]+dy[k];
                    if (0<=nx && nx<board.length && 0<=ny && ny<board[0].length) {
                        if (board[nx][ny]==0 && tmp[2]<count[nx][ny]) {
                            count[nx][ny]=tmp[2];
                            q.offer(new int[]{nx, ny, count[nx][ny]});
                        } else if (tmp[2]+1<count[nx][ny]) {
                            count[nx][ny]=tmp[2]+1;
                            q.offer(new int[]{nx, ny, count[nx][ny]});
                        }
                    }
                }
            }
        }

        return count[board.length-1][board[0].length-1];
    }

    public static void main(String[] args) {
        P03_벽허물기 T = new P03_벽허물기();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}
