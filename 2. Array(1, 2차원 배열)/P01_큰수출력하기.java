import java.util.*;
import java.io.*;

/*
N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
(첫 번째 수는 무조건 출력한다)
ex.
6
7 3 9 5 6 12
-> 7 9 6 12
 */
public class P01_큰수출력하기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder(String.valueOf(arr[0])+ " ");

        for (int i=1; i<arr.length; i++) {
            if (arr[i] > arr[i-1]) {
                sb.append(arr[i]).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
