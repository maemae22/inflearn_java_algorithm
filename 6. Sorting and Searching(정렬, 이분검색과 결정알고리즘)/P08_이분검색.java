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
        for (int i=0; i<N; i++) {
            if (arr[i] == M) {
                index = i+1;
            }
        }

        // 출력
        System.out.println(index);
    }
}
