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
        /*
        선택 정렬 : 첫 번째 자료를 두 번째 자료부터 마지막 자료까지 차례대로 비교하여 가장 작은 값을 찾아 첫 번째에 놓고,
                  두 번째 자료를 세 번째 자료부터 마지막 자료까지와 차례대로 비교하여 그 중 가장 작은 값을 찾아 두 번째 위치에 놓는 과정을 반복하며 정렬을 수행
                  1회전을 수행하고 나면 가장 작은 값의 자료가 맨 앞에 오게 되므로 그 다음 회전에서는 두 번째 자료를 가지고 비교한다.
                  마찬가지로 3회전에서는 세 번째 자료를 정렬한다.
        설명 : https://gmlwjd9405.github.io/2018/05/06/algorithm-selection-sort.html
         */
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
