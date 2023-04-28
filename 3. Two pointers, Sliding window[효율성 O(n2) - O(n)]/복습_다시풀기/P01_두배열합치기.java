package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P01_두배열합치기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
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
        int pa = 0;
        int pb = 0;

        while (pa<N && pb<M) {
            if (a[pa]<=b[pb]) {
                sb.append(a[pa]).append(" ");
                pa++;
            } else {
                sb.append(b[pb]).append(" ");
                pb++;
            }
        }

        if (pa == N) {
            for (int i=pb; i<M; i++) {
                sb.append(b[i]).append(" ");
            }
        } else if (pb == M) {
            for (int i=pa; i<N; i++) {
                sb.append(a[i]).append(" ");
            }
        }

        System.out.println(sb.toString());
    }

    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] answer = new int[N+M];
        for (int i=0; i<N; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            answer[N+i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(answer);

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<answer.length; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
