import java.util.*;
import java.io.*;

/*
N개의 수로 이루어진 수열이 주어집니다.
이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
ex.
8 6
1 2 1 3 1 1 1 2
-> 3 ( 설명 : 합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지 )
 */
public class P04_연속부분수열 {

    // 방법1. (사실상 방법2와 동일 .. !)
    public static void main(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 로직
        int sum = 0;
        int answer = 0;
        int lt = 0;
        int rt = 0;

        while (rt < N) {

            sum += arr[rt];
            rt++;

            while (sum > M) {
                sum -= arr[lt];
                lt++;
            }

            if (sum == M) {
                answer++;
//                System.out.println(lt+"부터 " + rt+"까지 = "+ M + " sum은" + sum);
                sum -= arr[lt];
                lt++;
            }
        }

        // 출력
        System.out.println(answer);
    }

    // 방법2.
    public static void main2(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 로직
        int sum = 0; // lt부터 rt까지의 합
        int answer = 0;
        int lt = 0;

        for (int rt=0; rt<N; rt++) {
            sum += arr[rt];
            if (sum == M) {
                answer++;
            }
            while (sum >= M) {
                sum -= arr[lt];
                lt++;

                if (sum == M) {
                    answer++;
                }
            }
        }

        // 출력
        System.out.println(answer);
    }

}
