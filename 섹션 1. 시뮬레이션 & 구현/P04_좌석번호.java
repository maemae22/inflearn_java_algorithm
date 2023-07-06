import java.util.*;

public class P04_좌석번호 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static int[] solution(int c, int r, int k){
        if (k>c*r) {
            return new int[] {0, 0};
        }

        int[][] seat = new int[r][c];
        int x = r-1;
        int y = 0;
        int direction = 0;
        seat[x][y] = 1;

        for (int i=1; i<k; i++) {
            int nx = x + dx[direction%4];
            int ny = y + dy[direction%4];
            if (!(0<=nx && nx<r && 0<=ny && ny<c) || seat[nx][ny]==1) {
                direction++;
            }

            x = x + dx[direction%4];
            y = y + dy[direction%4];
            seat[x][y]=1;
        }

//        System.out.println(x+"/"+y);
        return new int[] {y+1, 5-x};
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(6, 5, 5))); // 1 5
        System.out.println(Arrays.toString(solution(6, 5, 8))); // 4 5
        System.out.println(Arrays.toString(solution(6, 5, 12))); // 6 3
        System.out.println(Arrays.toString(solution(6, 5, 20))); // 2 3
        System.out.println(Arrays.toString(solution(6, 5, 30))); // 4 3
        System.out.println(Arrays.toString(solution(6, 5, 31))); // 0 0
    }
}
