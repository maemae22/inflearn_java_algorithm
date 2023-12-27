package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P05_다익스트라알고리즘 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        ArrayList<ArrayList<Go>> list = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            list.add(new ArrayList<Go>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Go(b, c));
        }

        int[] answer = new int[N+1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[1]=0;

        Queue<Go> q = new LinkedList<>();
        q.offer(new Go(1, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                Go tmp = q.poll();
                for (Go next : list.get(tmp.next)) {
                    int cost = answer[tmp.next] + next.pay;
                    if (cost<answer[next.next]) {
                        answer[next.next]=cost;
                        q.offer(new Go(next.next, cost));
                    }
                }
            }
        }

        for (int i=2; i<=N; i++) {
            System.out.print(i+" : ");
            if (answer[i]==Integer.MAX_VALUE) {
                System.out.print("impossible");
            } else {
                System.out.print(answer[i]);
            }
            System.out.println();
        }
    }
}

class Go implements Comparable<Go> {
    int next;
    int pay;
    Go(int next, int pay) {
        this.next = next;
        this.pay = pay;
    }
    @Override
    public int compareTo(Go o) {
        return this.pay - o.pay;
    }
}
