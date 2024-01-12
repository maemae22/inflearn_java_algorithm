import java.util.*;

public class P04_미로의최단거리통로_L탐색 {
    public int solution(int[][] board) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        int[][] check = new int[board.length][board[0].length];
        check[0][0]=1;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (answer<=50 && !q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int[] tmp = q.poll();
                for (int k=0; k<4; k++) {
                    int nx = tmp[0]+dx[k];
                    int ny = tmp[1]+dy[k];
                    if (nx==6 && ny==6) {
                        return answer+1;
                    }
                    if (0<=nx && nx<7 && 0<=ny && ny<7 && board[nx][ny]==0 && check[nx][ny]==0) {
                        check[nx][ny]=1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
            answer++;
        }

        return -1;
    }

    public static void main(String[] args) {
        P04_미로의최단거리통로_L탐색 T = new P04_미로의최단거리통로_L탐색();
        int[][] arr={{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};
        int[][] arr2={{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0}};
        System.out.println(T.solution(arr));
        System.out.println(T.solution(arr2));
    }
}
