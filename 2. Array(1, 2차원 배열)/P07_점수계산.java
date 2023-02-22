import java.util.*;
import java.io.*;

/*
여러 개의 OX 문제로 만들어진 시험에서 연속적으로 답을 맞히는 경우에는 가산점을 주기 위해서 다음과 같이 점수 계산을 하기로 하였다.
1번 문제가 맞는 경우에는 1점으로 계산한다. 앞의 문제에 대해서는 답을 틀리다가 답이 맞는 처음 문제는 1점으로 계산한다.
또한, 연속으로 문제의 답이 맞는 경우에서 두 번째 문제는 2점, 세 번째 문제는 3점, ..., K번째 문제는 K점으로 계산한다. 틀린 문제는 0점으로 계산한다.
답이 맞은 문제의 경우에는 1로 표시하고, 틀린 경우에는 0으로 표시한다.
시험문제의 채점 결과가 주어졌을 때, 총 점수를 계산하는 프로그램을 작성하시오.
ex.
10
1 0 1 1 1 0 0 1 1 0
-> 10 ( 설명 : 1+1+2+3+1+2=10 )
*/
public class P07_점수계산 {

    // 방법1.
    public static void main1(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] point = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            point[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int count = 1;
        if (point[0] == 1) {
            answer++;
        }
        for (int i=1; i<N; i++) {
            if (point[i] == 1) {
                if (point[i-1] == 1) {
                    count++;
                } else {
                    count = 1;
                }
                answer += count;
            }
        }

        System.out.println(answer);
    }

    // 방법2. (더 좋음 !)
    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] point = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            point[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int count = 0;

        for (int i=0; i<N; i++) {
            if (point[i] == 1) {
                count++;
                answer += count;
            } else {
                count = 0;
            }
        }

        System.out.println(answer);
    }
}
