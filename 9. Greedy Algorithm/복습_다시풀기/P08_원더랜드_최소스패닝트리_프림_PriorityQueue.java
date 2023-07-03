package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P08_원더랜드_최소스패닝트리_프림_PriorityQueue {

    static int[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Edge>> list = new ArrayList<>();
        for (int i=0; i<=V; i++) {
            list.add(new ArrayList<Edge>());
        }
        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Edge(b, c));
            list.get(b).add(new Edge(a, c));
        }

        check = new int[V+1];
        check[1] = 1;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (Edge tmp : list.get(1)) {
            pq.offer(tmp);
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            Edge tmp = pq.poll();
            if (check[tmp.num]==0) {
                check[tmp.num] = 1;
                answer += tmp.cost;
                for (Edge add : list.get(tmp.num)) {
                    pq.offer(add);
                }
            }
        }

        System.out.println(answer);
    }

}

class Edge implements Comparable<Edge> {
    int num;
    int cost;
    Edge (int num, int cost) {
        this.num = num;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
