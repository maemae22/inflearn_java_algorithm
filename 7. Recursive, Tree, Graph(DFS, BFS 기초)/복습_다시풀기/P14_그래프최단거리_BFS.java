package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P14_그래프최단거리_BFS {

    static int[] answer;
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
        }

        answer = new int[N+1];
        answer[1] = 1;

        BFS();
        for (int i=2; i<=N; i++) {
            System.out.println(i + " : " + answer[i]);
        }
    }

    public static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int tmp = q.poll();
                for (int next : list.get(tmp)) {
                    if (answer[next]==0) {
                        answer[next] = level;
                        q.offer(next);
                    }
                }
            }
            level++;
        }
    }
}
