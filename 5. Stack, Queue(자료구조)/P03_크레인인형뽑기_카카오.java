import java.util.*;
import java.io.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/64061?language=java
public class P03_크레인인형뽑기_카카오 {
    public static void main(String[] args) throws Exception {
        // 초기세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int M = Integer.parseInt(br.readLine());
        int[] moves = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }

        // 로직
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int j=0; j<M; j++) {
            int move = moves[j]-1;

            for (int i=0; i<N; i++) {
                if (arr[i][move] != 0) {
                    stack.push(arr[i][move]);

                    // 같은 인형인지 확인
                    if (stack.size() >=2 && stack.get(stack.size()-2) == arr[i][move]) {
                        stack.pop();
                        stack.pop();
                        count += 2;
                    }

                    arr[i][move] = 0;
                    break;
                }
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}
