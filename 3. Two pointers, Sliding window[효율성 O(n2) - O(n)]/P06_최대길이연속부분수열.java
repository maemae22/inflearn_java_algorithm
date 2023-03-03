import java.util.*;
import java.io.*;

/*
0과 1로 구성된 길이가 N인 수열이 주어집니다.
여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다.
여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
ex.
14 2
1 1 0 0 1 1 0 1 1 0 1 1 0 1
-> 8 ( 설명 : 1 1 0 0 1 1 1 1 1 1 1 1 0 1 )
 */
public class P06_최대길이연속부분수열 {

    // 투 포인터 알고리즘 사용
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0; // 최대 길이 (정답)
        int change = 0; // 0을 1로 바꾼 횟수
        int lt = 0; // 투 포인터 알고리즘의 왼쪽

        for (int rt=0; rt<N; rt++) {

            if (arr[rt] == 0) {
                change++;
            }

            // 방법 1-1.
            if (change > K) {
                while (arr[lt] == 1) {
                    lt++;
                }
                change--; // arr[lt] == 0 일 때, change 를 1 내림 (아까 0->1로 바꿔서 카운팅 했던 걸 빼버림)
                lt++; // lt 증가
            }

            /*
            // 방법 1-2.
            while (change > K) {
                if (arr[lt] == 0) {
                    change--;
                }
                lt++;
            }
             */

            max = Math.max(max, rt-lt+1);
        }

        System.out.println(max);
    }
}
