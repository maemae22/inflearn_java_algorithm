package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P03_크레인인형뽑기_카카오 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Queue<Integer>> list = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            list.add(new LinkedList<>());
        }

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num != 0) {
                    list.get(j+1).offer(num);
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        int[] moves = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        Stack<Integer> basket = new Stack<>();

        for (int move : moves) {
            if (!list.get(move).isEmpty()) {
                int doll = list.get(move).poll();
                if (!basket.isEmpty() && basket.peek()!=doll || basket.isEmpty()) {
                    basket.add(doll);
                } else {
                    answer++;
                    basket.pop();
                }
            }
        }

        System.out.println(2*answer);
    }
}
