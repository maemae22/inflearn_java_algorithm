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

    public int solution2(int[][] board) {
        int N = board.length;
        int[][] dis = new int[N][N];

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int emptyLand = 0;

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (board[i][j]==1) {
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    int L = 1;

                    while (!q.isEmpty()) {
                        int size = q.size();
                        for (int k=0; k<size; k++) {
                            int[] now = q.poll();
                            for (int p=0; p<4; p++) {
                                int nx = now[0]+dx[p];
                                int ny = now[1]+dy[p];
                                if (0<=nx && nx<N && 0<=ny && ny<N && board[nx][ny]==emptyLand) {
                                    board[nx][ny]=emptyLand-1;
                                    q.offer(new int[]{nx, ny});
                                    dis[nx][ny] += L;
                                }
                            }
                        }
                        if (L==1 && q.size()==0) {
                            return -1;
                        }
                        L++;
                    }
                    emptyLand--;
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int[] tmp : dis) {
            for (int tmp2 : tmp) {
                if (tmp2!=0) {
                    answer = Math.min(answer, tmp2);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P05_집을짓자 T = new P05_집을짓자();
        System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
        System.out.println();
        System.out.println(T.solution2(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution2(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution2(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(T.solution2(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}
