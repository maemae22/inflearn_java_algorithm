package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P08_원더랜드_최소스패닝트리_프림_PriorityQueue {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Edge>> list = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            list.add(new ArrayList<Edge>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Edge(b, c));
            list.get(b).add(new Edge(a, c));
        }

        PriorityQueue<Edge> q = new PriorityQueue<>();
        int[] check = new int[N+1];
        int count = 0;
        check[1]=1;
        for (Edge tmp : list.get(1)) {
            q.offer(tmp);
        }

        int answer = 0;
        while (count!=N-1) {
            Edge tmp = q.poll();
            if (check[tmp.index]==0) {
                check[tmp.index]=1;
                answer += tmp.cost;
                count++;
                for (Edge next : list.get(tmp.index)) {
                    q.offer(next);
                }
            }
        }

        System.out.println(answer);
    }
}

class Edge implements Comparable<Edge> {
    int index;
    int cost;
    Edge(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
