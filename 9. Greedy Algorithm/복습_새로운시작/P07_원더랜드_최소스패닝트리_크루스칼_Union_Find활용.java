package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P07_원더랜드_최소스패닝트리_크루스칼_Union_Find활용 {

    static int[] unf;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        unf = new int[V+1];
        for (int i=0; i<=V; i++) {
            unf[i]=i;
        }

        ArrayList<ArrayList<Road>> list = new ArrayList<>();
        for (int i=0; i<=V; i++) {
            list.add(new ArrayList<Road>());
        }

        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Road(b, c));
            list.get(b).add(new Road(a, c));
        }

        int answer = 0;
        PriorityQueue<Road> q = new PriorityQueue<>();
        for (Road tmp : list.get(1)) {
            q.offer(tmp);
        }

        while (!q.isEmpty()) {
            Road tmp = q.poll();
            if (find(1)!=find(tmp.index)) {
                answer += tmp.pay;
                union(1, tmp.index);
                for (Road next : list.get(tmp.index)) {
                    q.offer(next);
                }
            }
        }

        System.out.println(answer);
    }

    public static void union(int a, int b) {
        if (find(a)!=find(b)) {
            unf[find(a)] = find(b);
        }
    }

    public static int find(int a) {
        if (unf[a]==a) {
            return a;
        } else {
            return unf[a] = find(unf[a]);
        }
    }
}

class Road implements Comparable<Road> {
    int index;
    int pay;
    Road(int index, int pay) {
        this.index = index;
        this.pay = pay;
    }

    @Override
    public int compareTo(Road o) {
        return this.pay - o.pay;
    }
}
