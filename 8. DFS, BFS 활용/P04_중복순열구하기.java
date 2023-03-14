import java.util.*;
import java.io.*;

/*
1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
입력 : 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.
출력 : 첫 번째 줄에 결과를 출력합니다. 출력순서는 사전순으로 오름차순으로 출력합니다.
ex.
3 2
->
1 1
1 2
1 3
2 1
2 2
2 3
3 1
3 2
3 3
 */
public class P04_중복순열구하기 {

    static int N, M;
    static int[] answer;
    static ArrayList<String> answers;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answers = new ArrayList<String>();
        answer = new int[M];

        DFS(0);
        Collections.sort(answers);

        for (String answer : answers) {
            System.out.println(answer);
        }
    }

    public static void DFS(int level) {
        if (level == M) {
            StringBuilder sb = new StringBuilder();
            for (int num : answer) {
                sb.append(num);
                sb.append(" ");
            }
            answers.add(sb.toString());
        } else {
            for (int i=1; i<=N; i++) {
                answer[level] = i;
                DFS(level+1);
            }
        }
    }

}
