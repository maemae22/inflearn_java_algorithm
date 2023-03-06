import java.util.*;
import java.io.*;

/*
N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요. 정렬하는 방법은 선택정렬입니다.
ex.
6
13 5 11 7 23 15
-> 5 7 11 13 15 23
 */
public class P01_선택정렬 {

    // 방법1. Arrays.sort(arr); 사용
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);
        for (int tmp : arr) {
            sb.append(tmp);
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}
