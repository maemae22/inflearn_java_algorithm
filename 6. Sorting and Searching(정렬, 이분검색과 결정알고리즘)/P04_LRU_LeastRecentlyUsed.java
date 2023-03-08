import java.util.*;
import java.io.*;

/*
철수의 컴퓨터는 캐시메모리 사용 규칙이 LRU 알고리즘을 따른다.
LRU 알고리즘은 Least Recently Used 의 약자로 직역하자면 가장 최근에 사용되지 않은 것 정도의 의미를 가지고 있습니다.
캐시에서 작업을 제거할 때 가장 오랫동안 사용하지 않은 것을 제거하겠다는 알고리즘입니다.
캐시의 크기가 주어지고, 캐시가 비어있는 상태에서 N개의 작업을 CPU가 차례로 처리한다면 N개의 작업을 처리한 후
캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램을 작성하세요.
ex.
5 9
1 2 3 2 6 2 3 5 7
-> 7 5 3 2 6
 */
public class P04_LRU_LeastRecentlyUsed {
    public static void main(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 로직
        int[] answer = new int[S];
        // 방법1. (방법2와 로직은 동일)
        for (int i=0; i<N; i++) {
            int push = arr[i];
            int index = indexArray(answer, push);

            if (index != -1) { // answer 배열에 존재하면
                for (int j=index-1; j>=0; j--) {
                    answer[j+1] = answer[j];
                }
            } else { // answer 배열에 존재하지 않으면
                for (int j=S-2; j>=0; j--) {
                    answer[j+1] = answer[j];
                }
            }
            answer[0] = push;
        }

        /*
        // 방법2.
        for (int i=0; i<N; i++) {
            int index = -1;
            for (int j=0; j<answer.length; j++) {
                if (answer[j] == arr[i]) {
                    index = j;
                }
            }

            if (index == -1) {
                for (int k=answer.length-1; k>=1; k--) {
                    answer[k] = answer[k-1];
                }
            } else {
                for (int k=index; k>=1; k--) {
                    answer[k] = answer[k-1];
                }
            }

            answer[0] = arr[i];
        }
         */


        // 출력 : answer 배열 출력
        StringBuilder sb = new StringBuilder();
        for (int tmp : answer) {
            sb.append(tmp);
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }

    // push 값이 answer 배열의 몇 번째 index에 있는지 확인해주는 메서드, push가 해당 배열에 존재하지 않으면 -1을 리턴한다.
    public static int indexArray(int[] answer, int push) {
        for (int i=0; i<answer.length; i++) {
            if (answer[i] == push) {
                return i;
            }
        }
        return -1;
    }
}
