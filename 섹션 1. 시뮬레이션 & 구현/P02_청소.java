import java.util.*;

public class P02_청소 {

    public static int[] solution(int[][] board, int k){
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int direction = 0;
        int anx = 0;
        int any = 0;

        for (int i=0; i<k; i++) {
            int nx = anx + dx[direction%4];
            int ny = any + dy[direction%4];
            if (!(0<=nx && nx<board.length && 0<=ny && ny<board.length) || board[nx][ny]==1) {
                direction++;
            } else {
                anx = nx;
                any = ny;
            }
//            System.out.println(i+" : "+nx+"/"+ny+"||"+anx+"/"+any);
        }

        int[] answer = {anx, any};
        return answer;
    }

    public static void main(String[] args){

        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(solution(arr1, 10)));

        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(solution(arr2, 20)));

        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(solution(arr3, 25)));

    }
}
