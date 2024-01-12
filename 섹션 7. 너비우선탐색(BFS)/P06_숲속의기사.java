import java.util.*;

public class P06_숲속의기사 {
    public int solution(int[][] board) {
        List<int[]> berry = new ArrayList<>();
        int[][] dis = new int[board.length][board[0].length];
        List<int[]> people = new ArrayList<>();

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j]==4) {
                    berry.add(new int[]{i, j});
                    board[i][j]=0;
                } else if (board[i][j]==2 || board[i][j]==3) {
                    people.add(new int[]{i, j});
                    board[i][j]=0;
                }
            }
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int canGo = 0;
        for (int i=0; i<2; i++) {
            Queue<int[]> q = new LinkedList<>();
            q.offer(people.get(i));

            int L = 1;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int j=0; j<size; j++) {
                    int[] now = q.poll();
                    for (int k=0; k<4; k++) {
                        int nx = now[0]+dx[k];
                        int ny = now[1]+dy[k];
                        if (0<=nx && nx<board.length && 0<=ny && ny<board[0].length && board[nx][ny]==canGo) {
                            board[nx][ny]--;
                            q.offer(new int[]{nx, ny});
                            dis[nx][ny] += L;
                        }
                    }
                }
                L++;
            }
            canGo--;
        }

        int answer = Integer.MAX_VALUE;
        for (int[] loc : berry) {
            answer = Math.min(answer, dis[loc[0]][loc[1]]);
        }

        return answer;
    }

    public static void main(String[] args) {
        P06_숲속의기사 T = new P06_숲속의기사();
        System.out.println(T.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}}));
        System.out.println(T.solution(new int[][]{{4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}}));
    }
}
