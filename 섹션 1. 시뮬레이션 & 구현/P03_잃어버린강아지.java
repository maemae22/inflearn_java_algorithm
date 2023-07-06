import java.util.*;
import java.io.*;

public class P03_잃어버린강아지 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static int solution(int[][] board){
        int px = 0;
        int py = 0;
        int ax = 0;
        int ay = 0;
        int pd = 0;
        int ad = 0;

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board.length; j++) {
                if (board[i][j]==2) {
                    px = i;
                    py = j;
                } else if (board[i][j]==3) {
                    ax = i;
                    ay = j;
                }
            }
        }

        int answer = 0;
        for (int i=0; i<10000; i++) {
            int npx = px + dx[pd%4];
            int npy = py + dy[pd%4];
            if (!(0<=npx && npx<10 && 0<=npy && npy<10) || board[npx][npy]==1) {
                pd++;
            } else {
                px = npx;
                py = npy;
            }

            int nax = ax + dx[ad%4];
            int nay = ay + dy[ad%4];
            if (!(0<=nax && nax<10 && 0<=nay && nay<10) || board[nax][nay]==1) {
                ad++;
            } else {
                ax = nax;
                ay = nay;
            }

            if (px==ax && py==ay) {
                answer = i+1;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(solution(arr1));

        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(solution(arr2));
    }
}
