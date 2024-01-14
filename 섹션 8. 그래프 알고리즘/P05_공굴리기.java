import java.util.*;

public class P05_공굴리기 {
    public int solution(int[][] board, int[] s, int[] e) {
        int[][] check = new int[board.length][board[0].length];
        for (int[] tmp : check) {
            Arrays.fill(tmp, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->a[2]-b[2]);
        check[s[0]][s[1]]=0;
        q.offer(new int[]{s[0], s[1], 0});

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (tmp[2]>check[tmp[0]][tmp[1]]) {
                continue;
            }
            for (int k=0; k<4; k++) {
                int nx = tmp[0];
                int ny = tmp[1];
                int count = 0;
                while (0<=nx+dx[k] && nx+dx[k]<board.length && 0<=ny+dy[k] && ny+dy[k]<board[0].length && board[nx+dx[k]][ny+dy[k]]==0) {
                    nx += dx[k];
                    ny += dy[k];
                    count++;
                }
                if (tmp[2]+count<check[nx][ny]) {
                    check[nx][ny]=tmp[2]+count;
                    q.offer(new int[]{nx, ny, check[nx][ny]});
                }
            }
        }

        return check[e[0]][e[1]]==Integer.MAX_VALUE ? -1 : check[e[0]][e[1]];
    }

    public static void main(String[] args) {
        P05_공굴리기 T = new P05_공굴리기();
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 3}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 3}));
    }
}
