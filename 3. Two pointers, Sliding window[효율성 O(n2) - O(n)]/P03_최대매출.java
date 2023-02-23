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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] sales = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            sales[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int rt = K-1;
        int max = 0;
        int sum = 0;

        for (int i=lt; i<=rt; i++) {
            sum += sales[i];
        }
        if (sum > max) {
            max = sum;
        }
        lt++;
        rt++;

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
}
