package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P13_경로탐색_인접리스트_ArrayList {

    static int N;
    static int answer = 0;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
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
        check[1]=1;
        DFS(1);
        System.out.println(answer);
    }

    public static void DFS(int start) {
        if (start==N) {
            answer++;
        } else {
            for (int go : list.get(start)) {
                if (check[go]==0) {
                    check[go]=1;
                    DFS(go);
                    check[go]=0;
                }
            }
        }
    }
}
