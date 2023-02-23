import java.util.*;
import java.io.*;

/*
오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
ex.
3
1 3 5
5
2 3 6 7 9
-> 1 2 3 3 5 6 7 9
 */
public class P01_두배열합치기 {

    // 방법1. Arrays.sort(arr); 로 오름차순 정렬
    public static void main1(String[] args) throws Exception {
        // 초기세팅 : arr 배열에 N+M 개의 숫자를 모두 저장함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N+M];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i=N; i<N+M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        // 오름차순 정렬된 것을 출력함
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<arr.length; i++) {
            sb.append(arr[i]);
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }

    // 방법2. two pointers algorithm 이용
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
        int[] b = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        // ⭐ 로직 : 투 포인터 알고리즘
        int pa = 0; // a 배열의 포인터
        int pb = 0; // b 배열의 포인터
        StringBuilder sb = new StringBuilder(); // sb에 정답 저장

        // 방법2-1.
        while (true) {
            if (a[pa] < b[pb]) {
                sb.append(a[pa]);
                sb.append(" ");
                pa++;
            } else {
                sb.append(b[pb]);
                sb.append(" ");
                pb++;
            }

            if ( pa==N || pb==M ) {
                break;
            }
        }

        if (pa==N) {
            for (int i=pb; i<M; i++) {
                sb.append(b[i]);
                sb.append(" ");
            }
        } else { // pb=M
            for (int i=pa; i<N; i++) {
                sb.append(a[i]);
                sb.append(" ");
            }
        }

        /*
        // 방법2-2.
        while ( pa<N && pb<M ) {
            if (a[pa] < b[pb]) {
                sb.append(a[pa++]);
                sb.append(" ");
            } else {
                sb.append(b[pb++]);
                sb.append(" ");
            }
        }

        while (pa<N) {
            sb.append(a[pa++]);
            sb.append(" ");
        }

        while (pb<M) {
            sb.append(b[pb++]);
            sb.append(" ");
        }
         */

        // 결과 출력
        System.out.println(sb.toString());
    }
}
