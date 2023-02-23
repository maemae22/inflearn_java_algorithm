import java.util.*;
import java.io.*;

/*
A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
ex.
5
1 3 9 5 2
5
3 2 5 7 8
-> 2 3 5
 */
public class P02_공통원소구하기 {

    public static void main(String[] args) throws Exception {
        // 초기세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[N];
        for (int i=0; i<N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] b = new int[M];
        for (int i=0; i<M; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(a);
        Arrays.sort(b);

        // 로직
        int pa = 0;
        int pb = 0;

        while (pa<N && pb<M) {
            if (a[pa] < b[pb]) {
                pa++;
            } else if (a[pa] > b[pb]) {
                pb++;
            } else { // 같으면 = 공통 원소
                sb.append(a[pa]).append(" ");
                pa++;
                pb++;
            }
        }

        // 출력
        System.out.println(sb.toString());
    }
}
