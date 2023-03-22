import java.util.*;
import java.io.*;

/*
N개의 자연수로 이루어진 수열이 주어졌을 때, 그 중에서 가장 길게 증가하는(작은 수에서 큰 수로) 원소들의 집합을 찾는 프로그램을 작성하라.
예를 들어, 원소가 2, 7, 5, 8, 6, 4, 7, 12, 3 이면 가장 길게 증가하도록 원소들을 차례대로 뽑아내면 2, 5, 6, 7, 12를 뽑아내어
길이가 5인 최대 부분 증가수열을 만들 수 있다.
첫째 줄은 입력되는 데이터의 수 N(3≤N≤1,000, 자연수)를 의미하고, 둘째 줄은 N개의 입력데이터들이 주어진다.
첫 번째 줄에 부분증가수열의 최대 길이를 출력한다.
ex.
8
5 3 7 8 6 2 9 4
->
4
 */
public class P03_최대부분증가수열_LIS {

    public static void main(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 로직

        // dy[i] = arr[i]번째 숫자를 마지막으로 하는 최대 부분 증가수열의 길이
        int[] dy = new int[N];
        int answer = 1; // 정답. dy[i] 값 중 최댓값이 정답이 된다.

        dy[0] = 1;
        for (int i=1; i<N; i++) {
            int max = 1;
            for (int j=0; j<i; j++) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, dy[j]+1);
                }
            }
            dy[i] = max;
            answer = Math.max(answer, dy[i]);
        }

//        System.out.println(Arrays.toString(dy));
        System.out.println(answer);
    }
}
