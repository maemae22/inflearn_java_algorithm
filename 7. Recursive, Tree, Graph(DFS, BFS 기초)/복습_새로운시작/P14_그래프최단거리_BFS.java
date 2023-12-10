package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P14_그래프최단거리_BFS {

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int N;
    static int[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i=0; i<=N; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
        }

        check = new int[N+1];
        check[0]=1;

        BFS(1);
        for (int i=2; i<=N; i++) {
            System.out.println(i+" : "+check[i]);
        }
    }

    public static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int tmp = q.poll();
                for (int next : list.get(tmp)) {
                    if (check[next]==0) {
                        check[next]=level+1;
                        q.offer(next);
                    }
                }
            }
            level++;
        }
    }
}
