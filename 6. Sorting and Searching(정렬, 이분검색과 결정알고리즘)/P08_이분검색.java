import java.util.*;
import java.io.*;

/*
임의의 N개의 숫자가 입력으로 주어집니다. N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면
이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요. 단 중복값은 존재하지 않습니다.
ex.
8 32
23 87 65 12 57 32 99 81
-> 3
 */
public class P08_이분검색 {

    public static void main(String[] args) throws Exception {
        // 초기세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 로직
        Arrays.sort(arr); // arr 배열 정렬
        int index = -1;

        // M이 정렬된 상태에서 몇 번째에 있는지 구하기
        /*
        // 방법1. for문을 돌면서 찾기
        for (int i=0; i<N; i++) {
            if (arr[i] == M) {
                index = i+1;
                break;
            }
        }
         */

        // 방법2. 이분 탐색(이진 탐색, Binary Search)으로 찾기
        // cf. 이분 탐색(이진 탐색) 설명 : https://velog.io/@kimdukbae/%EC%9D%B4%EB%B6%84-%ED%83%90%EC%83%89-%EC%9D%B4%EC%A7%84-%ED%83%90%EC%83%89-Binary-Search
        int lt = 0;
        int rt = arr.length -1;

        while (index == -1) { // 조건을 while (lt <= rt) 로 해도 됨 !
            int mid = (lt+rt) / 2;
            if (arr[mid] == M) {
                index = mid+1;
            } else if (arr[mid] < M) {
                lt = mid+1;
            } else { // M < arr[mid]
                rt = mid-1;
            }
        }


        // 출력
        System.out.println(index);
    }
}
