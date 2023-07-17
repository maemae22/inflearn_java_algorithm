import java.util.*;

public class P07_비밀번호 {

    public int solution(int[] keypad, String password) {
        int answer = 0;
        int[][] key = new int[10][2];
        int count = 0;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                key[keypad[count]][0] = i;
                key[keypad[count]][1] = j;
                count++;
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

    public int solution2(int[] keypad, String password) {
        int[][] arr = new int[3][3];
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                arr[i][j] = keypad[i*3+j];
            }
        }

        int[][] dis = new int[10][10];
        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                if (i!=j) {
                    dis[i][j] = 2;
                }
            }
        }

        int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
        int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                int num = arr[i][j];
                for (int k=0; k<8; k++) {
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if (0<=nx && nx<3 && 0<=ny && ny<3) {
                        dis[num][arr[nx][ny]] = 1;
                    }
                }
            }
        }

        int answer = 0;
        int pri = (int)(password.charAt(0)) - 48;
        for (char c : password.toCharArray()) {
            int next = (int)c - 48;
            answer += dis[pri][next];
            pri = next;
        }

        return answer;
    }

    public static void main(String[] args){
        P07_비밀번호 T = new P07_비밀번호();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
        System.out.println();
        System.out.println(T.solution2(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution2(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution2(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution2(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}