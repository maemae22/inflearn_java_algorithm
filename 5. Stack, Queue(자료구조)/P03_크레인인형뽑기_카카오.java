import java.util.*;
import java.io.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/64061?language=java
public class P03_크레인인형뽑기_카카오 {

    // 방법1. ( 방법2와 유사 / 일단 stack에 추가 후, 비교 )
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

    // 방법2. stack에 넣기 전에 stack.peek() 해서 확인. 같을 경우 넣지 않는다. 그냥 pop() 1번만.
    public static void main2(String[] args) throws Exception {
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
            for (int i=0; i<N; i++) {
                if (arr[i][moves[j]-1] != 0) {
                    int doll = arr[i][moves[j]-1];

                    // 같은 인형인지 확인
                    if (!stack.isEmpty() && doll==stack.peek()) {
                        stack.pop();
                        count += 2;
                    } else {
                        stack.push(doll);
                    }

                    arr[i][moves[j]-1] = 0;
                    break;
                }
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}
