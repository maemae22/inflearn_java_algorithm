package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P03_크레인인형뽑기_카카오 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int M = Integer.parseInt(br.readLine());
        int[] moves = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            moves[i] = Integer.parseInt(st.nextToken())-1;
        }

        ArrayList<Stack<Integer>> list = new ArrayList<>();
        for (int i=0; i<N; i++) {
            list.add(new Stack<Integer>());
        }

        for (int i=N-1; i>=0; i--) {
            for (int j=0; j<N; j++) {
                if (arr[i][j]!=0) {
                    list.get(j).push(arr[i][j]);
                }
            }
        }

        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        for (int tmp : moves) {
            if (!list.get(tmp).isEmpty()) {
                int doll = list.get(tmp).pop();
                if (!basket.isEmpty() && basket.peek()==doll) {
                    answer += 2;
                    basket.pop();
                } else {
                    basket.push(doll);
                }
            }
        }

        System.out.println(answer);
    }
}
