package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P04_연속부분수열 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int rt = 0;
        int count = 0;
        int sum = 0;
        while (rt<N) {
            if (sum > M) {
                sum -= arr[lt];
                lt++;
            } else if (sum < M) {
                sum += arr[rt];
                rt++;
            } else { // sum == M
//                System.out.println(lt + "/" + rt);
                count++;
                sum -= arr[lt];
                sum += arr[rt];
                lt++;
                rt++;
            }
        }

//        System.out.println("lt = " + lt);
//        System.out.println("rt = " + rt);
//        System.out.println("sum = " + sum);

        while (lt < N && sum>=M) {
            if (sum == M) {
//                System.out.println("특별함" + lt + "/" + rt);
                count++;
                break;
            }
            sum -= arr[lt];
            lt++;
        }

        System.out.println(count);
    }

    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int count = 0;
        int sum = 0;
        for (int rt=0; rt<N; rt++) {
            sum += arr[rt];
            if (sum == M) {
                count++;
                sum -= arr[lt];
                lt++;
            }
            while (sum >= M) {
                if (sum == M) {
                    count++;
                }
                sum -= arr[lt];
                lt++;
            }
        }

        System.out.println(count);
    }
}
