package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P03_최대점수구하기_DFS {

    static int answer;
    static int[] scores;
    static int[] times;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        scores = new int[N];
        times = new int[N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            scores[i] = Integer.parseInt(st.nextToken());
            times[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0, 0);
        System.out.println(answer);
    }

    public static void DFS(int index, int timeSum, int scoreSum) {
        if (timeSum>M) {
            answer = Math.max(answer, scoreSum-scores[index-1]);
        } else if (index == N) {
            answer = Math.max(answer, scoreSum);
        } else {
            DFS(index+1, timeSum+times[index], scoreSum+scores[index]);
            DFS(index+1, timeSum, scoreSum);
        }
    }
}
