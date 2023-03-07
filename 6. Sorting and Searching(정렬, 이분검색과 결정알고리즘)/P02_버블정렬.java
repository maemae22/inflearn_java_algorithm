import java.util.*;
import java.io.*;

/*
N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요. 정렬하는 방법은 버블 정렬입니다.
ex.
6
13 5 11 7 23 15
-> 5 7 11 13 15 23
 */
public class P02_버블정렬 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        // ⭐ arr 배열을 버블정렬을 이용하여 정렬하기 !
        // 방법1. 버블정렬 (1)
        for (int i=0; i<N-1; i++) {
            for (int j=0; j<N-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        /*
        // 방법2. 버블정렬 (2)
        for (int i=N-1; i>0; i--) {
            for (int j=0; j<i; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
         */


        // 정렬된 배열을 출력 !
        for (int tmp : arr) {
            sb.append(tmp);
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}
