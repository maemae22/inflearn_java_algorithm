import java.util.*;
import java.io.*;

/*
N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.
ex.
5
87 89 92 100 76
-> 4 3 2 1 5
 */
public class P08_등수구하기 {

    public static void main(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        int[] answer = new int[N];
        int count = 0;
        int myScore = 0;

        // 로직
        for (int i=0; i<N; i++) {
            myScore = scores[i];
            for (int j=0; j<N; j++) {
                if (scores[j] > myScore) {
                    count++; // 나보다 점수가 높은 학생 수를 구함.
                }
            }
            answer[i] = 1 + count;
            count = 0;
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            sb.append(answer[i]);
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}
