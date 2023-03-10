import java.util.*;
import java.io.*;

/*
학생 중에서 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 정하려 한다.
각 학생들이 1학년부터 5학년까지 속했던 반이 주어질 때, 임시 반장을 정하는 프로그램을 작성하시오.
단, 임시 반장이 될 수 있는 학생이 여러 명인 경우에는 그 중 가장 작은 번호만 출력한다.
첫째 줄에는 반의 학생 수를 나타내는 정수가 주어진다. 학생 수는 3 이상 1000 이하이다.
둘째 줄부터는 1번 학생부터 차례대로 각 줄마다 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 5개의 정수가 빈칸 하나를 사이에 두고 주어진다.
ex.
5
2 3 1 7 3
4 1 9 6 8
5 5 2 4 4
6 5 2 6 7
8 4 2 2 2
-> 4
 */
public class P11_임시반장정하기 {

    // 방법1.
    public static void main1(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][5];

        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int studentNum = 0;

        for (int i=1; i<=N; i++) {
            int count = 0;
            int[] same = new int[N+1];
            for (int j=0; j<5; j++) {
                for(int k=1; k<=N; k++) {
                    if (arr[i][j] == arr[k][j]) {
                        same[k]++;
                    }
                }
            }

            for (int t=1; t<=N; t++) {
                if (same[t]>=1) {
                    count++;
                }
            }

            if (count > max) {
                studentNum = i;
                max = count;
            }
        }

        System.out.println(studentNum);
    }

    // 방법2. 사실상 1번이랑 로직 똑같음 .. !
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][6];

        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=1; j<=5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int studentNum = 0;

        for (int i=1; i<=N; i++) { // ex. 1번 학생일때
            int count = 0;

            for (int j=1; j<=N; j++) { // ex. 1~N번 학생이랑 비교
                for (int k=1; k<=5; k++) { // 1~5학년까지 돌면서 비교
                    if (arr[i][k] == arr[j][k]) {
                        count++; // 1~5학년까지 돌면서 같은 반이였던 적이 있으면 count를 올려줌
                        break; // 똑같은 사람이 중복 집계되면 안되기 때문에 더이상 비교하지 않고 break.
                                // (ex. 2학년, 3학년 때 모두 같은 반이였다면, break가 없을 시 2명으로 집계됨)
                    }
                }
            }

            if (count > max) {
                studentNum = i;
                max = count;
            }
        }

        System.out.println(studentNum);
    }
}
