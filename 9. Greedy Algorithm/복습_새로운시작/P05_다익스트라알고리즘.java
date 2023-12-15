package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P05_다익스트라알고리즘 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Pair>> list = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            list.add(new ArrayList<Pair>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Pair(b, c));
        }

        int[] answer = new int[N+1];
        int[] check = new int[N+1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[1] = 0;

        PriorityQueue<Pair> pQ = new PriorityQueue<>();
        pQ.offer(new Pair(1, 0));

        while (!pQ.isEmpty()) {
            Pair tmp = pQ.poll();
            int index = tmp.index;
            if (check[index] == 1) {
                continue;
            }
            check[index] = 1;
            for (int j=0; j<list.get(index).size(); j++) {
                Pair pair = list.get(index).get(j);
                if (check[pair.index] == 0) {
                    answer[pair.index] = Math.min(answer[pair.index], tmp.min+pair.min);
                    pQ.add(new Pair(pair.index, answer[pair.index]));
                }
            }
        }

        // 출력
        for (int i=2; i<=N; i++) {
            if (answer[i] == Integer.MAX_VALUE) {
                System.out.println(i + " : impossible");
            } else {
                System.out.println(i + " : " + answer[i]);
            }
        }
    }
}

class Pair implements Comparable<Pair> {
    int index;
    int min;

    public Pair(int index, int min) {
        this.index = index;
        this.min = min;
    }

    @Override
    public int compareTo(Pair o) {
        return this.min - o.min;
    }
}
