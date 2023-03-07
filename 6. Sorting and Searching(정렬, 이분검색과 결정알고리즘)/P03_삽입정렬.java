import java.util.*;
import java.io.*;

/*
N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요. 정렬하는 방법은 삽입 정렬입니다.
ex.
6
11 7 5 6 10 9
-> 5 6 7 9 10 11
 */
public class P03_삽입정렬 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        // ⭐ arr 배열을 삽입 정렬을 이용하여 정렬하기 !
        // 삽입 정렬 : 두 번째 자료부터 시작하여 그 앞(왼쪽)의 자료들과 비교하여 삽입할 위치를 지정한 후,
        //            자료를 뒤로 옮기고 지정한 자리에 자료를 삽입하여 정렬하는 알고리즘
        // 설명 : https://gmlwjd9405.github.io/2018/05/06/algorithm-insertion-sort.html

        // 방법1. 삽입 정렬 (1)
        for (int i=1; i<N; i++) {
//            System.out.println(Arrays.toString(arr));
            int tmp = arr[i];

            // tmp의 위치를 찾아서 삽입하기 !
            for (int j=i-1; j>=0; j--) {
                if (arr[j] > tmp) {
                    arr[j+1] = arr[j];
                    if (j==0) {
                        arr[j] = tmp;
                    }
                } else { // arr[j] <= arr[i]
                    arr[j+1] = tmp;
                    break;
                }
            }
        }

        /*
        // 방법2. 삽입 정렬 (2)
        for (int i=1; i<N; i++) {
            int tmp = arr[i];
            int j=0;

            // tmp의 위치를 찾아서 삽입하기 !
            for (j=i-1; j>=0; j--) {
                if (arr[j] > tmp) {
                    arr[j+1] = arr[j];
                } else { // arr[j] <= arr[i]
                    break;
                }
            }

            arr[j+1] = tmp;
        }
         */

        /*
        // 방법3. 삽입 정렬 (3) - 제일 깔끔한 코드 !
        for (int i=1; i<N; i++) {
            int tmp = arr[i];
            int j=0;

            for (j=i-1; j>=0 && arr[j]>tmp ; j--) {
                arr[j+1] = arr[j];
            }

            arr[j+1] = tmp;
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
