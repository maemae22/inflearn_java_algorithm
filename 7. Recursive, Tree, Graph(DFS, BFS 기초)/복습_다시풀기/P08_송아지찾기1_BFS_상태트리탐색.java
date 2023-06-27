package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P08_송아지찾기1_BFS_상태트리탐색 {

    static int answer;
    static int[] check;
    static int[] dx = {-1, 1, 5};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        check = new int[10001];
        System.out.println(BFS(S, E));
    }

    public static int BFS(int S, int E) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        check[S] = 1;

        answer = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int tmp = q.poll();
                for (int k=0; k<dx.length; k++) {
                    int nx = tmp + dx[k];
                    if (nx == E) {
                        return answer+1;
                    } else if (check[nx]==0 && nx>0) {
                        check[nx] = 1;
                        q.offer(nx);
                    }
                }
            }
            answer++;
        }
        return -7;
    }
}
