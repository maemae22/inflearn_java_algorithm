package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P05_다익스트라알고리즘 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Line>> list = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            list.add(new ArrayList<Line>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Line(b, c));
        }

        int[] answer = new int[N+1];
        int[] check = new int[N+1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[1] = 0;
        PriorityQueue<Line> pQ = new PriorityQueue<>();
        pQ.offer(new Line(1, 0));

        while (!pQ.isEmpty()) {
            Line start = pQ.poll();
            if (check[start.num]==0) {
                check[start.num]=1;
                for (Line line : list.get(start.num)) {
                    if (check[line.num]==0) {
                        answer[line.num] = Math.min(answer[line.num], answer[start.num]+line.cost);
                        pQ.offer(new Line(line.num, answer[line.num]));
                    }
                }
            }
        }

        for (int i=2; i<=N; i++) {
            System.out.println(i+" : "+ (answer[i]==Integer.MAX_VALUE ? "impossible" : answer[i]));
        }

    }
}

class Line implements Comparable<Line> {
    int num;
    int cost;
    Line(int num, int cost) {
        this.num = num;
        this.cost = cost;
    }

    @Override
    public int compareTo(Line o) {
        return this.cost - o.cost;
    }
}
