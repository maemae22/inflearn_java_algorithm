package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P04_중복순열구하기 {

    static int[] answer;
    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new int[M];
        DFS(0);
    }

    public static void DFS(int index) {
        if (index==M) {
            for (int tmp : answer) {
                System.out.print(tmp+" ");
            }
            System.out.println();
        } else {
            for (int i=1; i<=N; i++) {
                answer[index]=i;
                DFS(index+1);
            }
        }
    }
}
