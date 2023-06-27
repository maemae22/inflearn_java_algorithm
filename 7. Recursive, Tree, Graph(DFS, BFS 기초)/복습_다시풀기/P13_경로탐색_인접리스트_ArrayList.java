package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P13_경로탐색_인접리스트_ArrayList {

    static int[] check;
    static int N;
    static int answer;
    static HashMap<Integer, ArrayList<Integer>> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        for (int i=0; i<=N; i++) {
            map.put(i, new ArrayList<Integer>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
        }

        check = new int[N+1];
        check[1] = 1;
        answer = 0;
        DFS(1, N);

        System.out.println(answer);
    }

    public static void DFS(int start, int end) {
        if (start == end) {
            answer++;
        } else {
            for (int i=0; i<map.get(start).size(); i++) {
                int next = map.get(start).get(i);
                if (check[next]==0) {
                    check[next] = 1;
                    DFS(next, N);
                    check[next] = 0;
                }
            }
        }
    }
}
