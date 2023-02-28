import java.util.*;
import java.io.*;

// N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
// ex. 15 -> 3 ( 7+8 / 4+5+6 / 1+2+3+4+5 )
public class P05_연속된자연수의합 {

    // 방법1.
    public static void main1(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        int lt = 1;
        int rt = 1;
        int sum = 1;

        while (rt <= (N+1)/2) {
            if (sum < N) {
                rt++;
                sum += rt;
            } else if (sum > N) {
                sum -= lt;
                lt++;
            } else { // sum == N
                answer++;
                System.out.println( lt+"부터 "+rt+"까지 = "+N+" / sum = "+sum);
                sum -= lt;
                lt++;
            }
        }

        System.out.println(answer);
    }

    // 방법2. 투 포인터 알고리즘
    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int half = N/2 + 1;
        int[] arr = new int[half];
        for (int i=0; i<half; i++) {
            arr[i] = i+1;
        }

        int answer = 0;
        int lt = 0;
        int sum = 0;

        for (int rt=0; rt<half; rt++) {
            sum += arr[rt];

            if (sum == N) {
                answer++;
            }

            while (sum == N) {
                sum -= arr[lt];
                lt++;
                if (sum == N) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    // 방법3. 수학 원리 사용
    public static void main3(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        int count = 1; // 연속된 자연수의 개수
        N--;

        while (N>0) {
            count++;
            N = N - count;
            if (N%count == 0) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
