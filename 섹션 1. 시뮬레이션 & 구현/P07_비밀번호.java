import java.util.*;

public class P07_비밀번호 {

    public int solution(int[] keypad, String password) {
        int answer = 0;
        int[][] key = new int[10][2];
        int count = -1;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                count++;
                key[keypad[count]][0] = i;
                key[keypad[count]][1] = j;
            }
        }

        int first = Integer.parseInt(String.valueOf(password.charAt(0)));
        int nowI = key[first][0];
        int nowJ = key[first][1];

        for (int i=1; i<password.length(); i++) {
            int next = Integer.parseInt(String.valueOf(password.charAt(i)));
            int nextI = key[next][0];
            int nextJ = key[next][1];
            int length = Math.max(Math.abs(nowI-nextI), Math.abs(nowJ-nextJ));
            answer += length;
            nowI = nextI;
            nowJ = nextJ;
//            System.out.print(i+"번째 길이는 = "+length+" / ");
        }

        return answer;
    }

    public static void main(String[] args){
        P07_비밀번호 T = new P07_비밀번호();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}