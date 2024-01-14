import java.util.*;

public class P04_방향바꾸기 {
    public int solution(int[][] board) {
        int[][] count = new int[board.length][board[0].length];
        for (int[] tmp : count) {
            Arrays.fill(tmp, Integer.MAX_VALUE);
        }
        int[] dx = {0, 0, 0, 1, -1};
        int[] dy = {0, 1, -1, 0, 0};

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->a[2]-b[2]);
        q.add(new int[]{0, 0, 0});
        count[0][0]=0;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (tmp[2]>count[tmp[0]][tmp[1]]) {
                continue;
            }
            for (int k=1; k<=4; k++) {
                int nx = tmp[0]+dx[k];
                int ny = tmp[1]+dy[k];
                if (0<=nx && nx<board.length && 0<=ny && ny<board[0].length) {
                    if (k==board[tmp[0]][tmp[1]] && tmp[2]<count[nx][ny]) {
                        count[nx][ny]=tmp[2];
                        q.offer(new int[]{nx, ny, count[nx][ny]});
                    } else if (k!=board[tmp[0]][tmp[1]] && tmp[2]+1<count[nx][ny]) {
                        count[nx][ny]=tmp[2]+1;
                        q.offer(new int[]{nx, ny, count[nx][ny]});
                    }
                }
            }
        }

        return count[board.length-1][board[0].length-1];
    }

    public static void main(String[] args) {
        P04_방향바꾸기 T = new P04_방향바꾸기();
        System.out.println(T.solution(new int[][]{{3, 1, 3}, {1, 4, 2}, {4, 2, 3}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2}, {2, 1, 1, 1, 4, 2}, {2, 2, 2, 1, 2, 2}, {1, 3, 3, 4, 4, 4}, {1, 2, 2, 3, 3, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2, 2, 2}, {2, 1, 1, 1, 4, 2, 1, 1}, {2, 2, 2, 1, 2, 2, 3, 4}, {1, 3, 3, 4, 4, 4, 3, 1}, {1, 2, 2, 3, 3, 4, 3, 4}, {1, 2, 2, 3, 3, 1, 1, 1}}));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 2, 1, 3, 1, 2, 2, 2}, {1, 2, 2, 1, 1, 1, 4, 2, 1, 1}, {3, 2, 2, 2, 2, 1, 2, 2, 3, 4}, {3, 3, 1, 3, 3, 4, 4, 4, 3, 1}, {1, 1, 1, 2, 2, 3, 3, 4, 3, 4}, {1, 1, 1, 2, 2, 3, 3, 1, 1, 1}}));
    }
}
