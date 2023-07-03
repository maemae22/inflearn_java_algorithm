package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P07_원더랜드_최소스패닝트리_크루스칼_Union_Find활용 {

    public static int[] unf;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        ArrayList<Road> list = new ArrayList<>();
        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Road(a, b, c));
        }

        Collections.sort(list);

        unf = new int[V+1];
        for (int i=0; i<=V; i++) {
            unf[i] = i;
        }

        int answer = 0;
        for (Road tmp : list) {
            if (find(tmp.num1)!=find(tmp.num2)) {
                union(tmp.num1, tmp.num2);
                answer += tmp.cost;
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
    int num1;
    int num2;
    int cost;
    Road(int num1, int num2, int cost) {
        this.num1 = num1;
        this.num2 = num2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Road o) {
        return this.cost - o.cost;
    }
}
