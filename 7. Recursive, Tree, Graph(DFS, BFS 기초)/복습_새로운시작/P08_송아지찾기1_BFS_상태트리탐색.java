package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P08_송아지찾기1_BFS_상태트리탐색 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        System.out.println(BFS(S, E));
    }

    public static int BFS(int S, int E) {
        Queue<Integer> q = new LinkedList<>();
        int[] check = new int[10001];
        int[] go = {1, -1, 5};

        q.offer(S);
        check[S]=1;
        int answer = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int tmp = q.poll();
                for (int k=0; k<go.length; k++) {
                    int nx = tmp+go[k];
                    if (nx==E) {
                        return answer+1;
                    } else if (0<=nx && check[nx]==0) {
                        check[nx] = 1;
                        q.offer(nx);
                    }
                }
            }
            answer++;
        }

        return -1;
    }
}
