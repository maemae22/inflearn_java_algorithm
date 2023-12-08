package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P06_공주구하기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=N; i++) {
            q.offer(i);
        }

        int count = 1;
        while (q.size()!=1) {
            if (count==K) {
                q.poll();
                count = 1;
            } else {
                count++;
                q.offer(q.poll());
            }
        }

        System.out.println(q.poll());
    }
}
