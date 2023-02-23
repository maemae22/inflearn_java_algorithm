import java.util.*;
import java.io.*;

/*
N일 동안의 매출기록이 있을 때, 연속된 K일 동안의 최대 매출액이 얼마인지 구하여라.
ex.
10 3
12 15 11 20 25 10 20 19 13 15
-> 56 (연속된 3일간의 최대 매출액은 11+20+25=56만원)
 */
public class P03_최대매출 {

    // 방법1. 슬라이딩 윈도우 (Sliding window)
    public static void main1(String[] args) throws Exception {
        // 초기세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] sales = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            sales[i] = Integer.parseInt(st.nextToken());
        }

        // ⭐ 로직 (Sliding window)
        int sum = 0;

        for (int i=0; i<=K-1; i++) {
            sum += sales[i];
        }
        int max = sum;
        int lt = 1;
        int rt = K;

        while (rt<N) {
            sum -= sales[lt-1];
            sum += sales[rt];
            if (sum > max) {
                max = sum;
            }
            lt++;
            rt++;
        }

        System.out.println(max);
    }

    // 방법2. 슬라이딩 윈도우 (Sliding window) - 로직은 방법1과 동일함. 코드만 리팩토링함.
    public static void main(String[] args) throws Exception {
        // 초기세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] sales = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            sales[i] = Integer.parseInt(st.nextToken());
        }

        // ⭐ 로직 (Sliding window)
        int sum = 0;

        for (int i=0; i<K; i++) {
            sum += sales[i];
        }
        int max = sum;

        for (int i=K; i<N; i++) {
            sum += (sales[i] - sales[i-K]);
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
