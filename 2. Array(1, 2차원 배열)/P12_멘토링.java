import java.util.*;
import java.io.*;

/*
선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.
만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.
M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 출력하는 프로그램을 작성하세요.
두 번째 줄부터 M개의 줄에 걸쳐 수학테스트 결과가 학생번호로 주어진다. 학생번호가 제일 앞에서부터 1등, 2등, ...N등 순으로 표현된다.
만약 한 줄에 N=4이고, 테스트 결과가 3 4 1 2로 입력되었다면 3번 학생이 1등, 4번 학생이 2등, 1번 학생이 3등, 2번 학생이 4등을 의미합니다.
ex.
4 3
3 4 1 2
4 3 2 1
3 1 4 2
-> 3 (설명 : (3, 1), (3, 2), (4, 2)와 같이 3가지 경우의 (멘토, 멘티) 짝을 만들 수 있다.)
 */
public class P12_멘토링 {

    // 방법1.
    public static void main1(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N = 학생 수
        int M = Integer.parseInt(st.nextToken()); // M = 시험 횟수

        int[][] scores = new int[M][N];
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        int[][] isMenti = new int[N][N];

        for (int i=0; i<M; i++) { // M개의 테스트를 돌면서 확인
            for (int j=N-1; j>=0; j--) {
                for (int k=0; j-k>=0; k++) {
                    isMenti[scores[i][j]-1][scores[i][j-k]-1]++;
                }
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (isMenti[i][j] == 0) {
                    answer++;
//                    System.out.println("멘토는 = " + (i+1) + ", 멘티는 = " + (j+1));
                }
            }
        }

        System.out.println(answer);
    }

    // 방법2.
    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N = 학생 수
        int M = Integer.parseInt(st.nextToken()); // M = 시험 횟수

        int[][] scores = new int[M][N];
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for (int i=1; i<=N; i++) { // i번 학생과
            for (int j=1; j<=N; j++) { // j번 학생이 멘토멘티가 될 수 있는 경우의 수를 구함 (총 경우의 수는 N*N번)
                int yes = 0;
                for (int k=0; k<M; k++) { // M번의 시험 성적을 확인 (i학생이 j학생의 멘토가 될 수 있는가?)
                    int pi = 0; // k번째 시험에서 i 학생의 등수
                    int pj = 0; // k번째 시험에서 j 학생의 등수

                    for (int t=0; t<N; t++) { // k번째 시험 성적 배열을 돌며 i 학생과 j 학생의 등수를 찾음
                        if (scores[k][t] == i) {
                            pi = t;
                        }
                        if (scores[k][t] == j) {
                            pj = t;
                        }
                    }

                    if (pi < pj) {
                        yes++; // i등수가 j 등수보다 작다면, k번째 시험에서 i는 j의 멘토 자격이 있음.
                    }
                }
                if (yes == M) { // M번의 모든 시험에서 i가 j의 멘토 조건이 성립한다면, 멘토임.
                    answer++;
//                    System.out.println("멘토는 = " + i + ", 멘티는 = " + j);
                }
            }
        }

        System.out.println(answer);
    }
}
