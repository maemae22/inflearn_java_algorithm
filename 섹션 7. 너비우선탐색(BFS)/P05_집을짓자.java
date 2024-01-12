import java.util.*;

public class P05_집을짓자 {
    public int solution(int[][] board) {
        int N = board.length;

        List<int[][]> dis = new ArrayList<>();
        List<Queue<int[]>> q = new ArrayList<>();
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (board[i][j]==1) {
                    q.add(new LinkedList<>());
                    q.get(q.size()-1).offer(new int[]{i, j});
                    dis.add(new int[N][N]);
                }
            }
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int M = dis.size(); // 빌딩의 개수
        int[] check = new int[M];
        int count = 0;
        int L = 1;

        while (count<M) {
            for (int i=0; i<M; i++) {
                if (check[i]==1) {
                    continue;
                }
                Queue<int[]> tmp = q.get(i);
                int size = tmp.size();
                if (size==0 && check[i]==0) {
                    count++;
                    check[i]=1;
                    break;
                }
                for (int j=0; j<size; j++) {
                    int[] now = tmp.poll();
                    for (int k=0; k<4; k++) {
                        int nx = now[0]+dx[k];
                        int ny = now[1]+dy[k];
                        if (0<=nx && nx<N && 0<=ny && ny<N && board[nx][ny]==0 && dis.get(i)[nx][ny]==0) {
                            q.get(i).offer(new int[]{nx, ny});
                            dis.get(i)[nx][ny]=L;
                        }
                    }
                }
            }
            L++;
        }

        int answer = Integer.MAX_VALUE;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (board[i][j]==0) {
                    int sum=0;
                    boolean ok = true;
                    for (int k=0; k<M; k++) {
                        int distance = dis.get(k)[i][j];
                        if (distance!=0) {
                            sum+=distance;
                        } else {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) {
                        answer = Math.min(answer, sum);
                    }
                }
            }
        }

        return answer!=Integer.MAX_VALUE ? answer : -1;
    }

    public static void main(String[] args) {
        P05_집을짓자 T = new P05_집을짓자();
        System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}
