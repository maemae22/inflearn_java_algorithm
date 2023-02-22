import java.util.*;
import java.io.*;

/*
1) 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
ex. 10 -> 1 1 2 3 5 8 13 21 34 55
 */
public class P04_피보나치수열 {

    // 방법1. 배열 이용하여 풀기
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N];
        answer[0] = 1;
        answer[1] = 1;

        for (int i=2; i<N; i++) {
            answer[i] = answer[i-2] + answer[i-1];
        }

        StringBuilder sb = new StringBuilder();
        for (int num : answer) {
            sb.append(num);
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }

    // 방법2. 배열 안쓰고 풀기
    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int first = 1;
        int second = 1;
        int third = 0;

        sb.append(first);
        sb.append(" ");
        sb.append(second);
        sb.append(" ");

        for (int i=2; i<N; i++) {
            third = first + second;
            sb.append(third);
            sb.append(" ");
            first  = second;
            second = third;
        }

        System.out.println(sb.toString());
    }
}
