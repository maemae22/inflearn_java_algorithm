import java.util.*;
import java.io.*;

// 자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하세요.
// ex. 3 -> 1 2 3
public class P01_재귀함수_스택프레임 {

    // 방법1. 재귀함수, DFS, 스택 프레임
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        DFS(N);
    }

    // ⭐ 재귀함수 !!! 자기자신을 호출 ... !  + System.out.print(n+" ");
    public static void DFS(int n) {
        if (n == 0) {
            return;
        } else {
//            System.out.print(n+" "); // 이 위치면 3 2 1 출력
            DFS(n-1);
            System.out.print(n+" "); // 이 위치면 1 2 3 출력
        }
    }


    // 방법2. for문 돌기 (재귀함수 이용 x)
    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] answer = new int[N];
        answer[0] = 1;
        for (int i=1; i<N; i++) {
            answer[i] = answer[i-1] + 1;
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int tmp : answer) {
            sb.append(tmp);
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }

}
