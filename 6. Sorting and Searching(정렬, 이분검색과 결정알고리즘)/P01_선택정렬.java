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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        // ⭐ arr 배열을 정렬하기 !
        // 방법1. Arrays.sort(arr);
//        Arrays.sort(arr);

        // 방법2. 선택정렬 이용
        for (int i=0; i<N; i++) { // i<N-1 로 해도 됨 .. !
            int minIndex = i;
            for (int j=i+1; j<N; j++) {
                // arr[i] 보다 작은 최솟값 찾기.
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // arr[i] 보다 작은 최솟값을 찾았으면, arr[i]와 최솟값 자리를 교환해준다.
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }

        for (int tmp : arr) {
            sb.append(tmp);
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}
