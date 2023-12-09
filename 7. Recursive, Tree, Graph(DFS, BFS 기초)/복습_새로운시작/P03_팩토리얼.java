package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P03_팩토리얼 {

    static int answer = 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        DFS(N);
        System.out.println(answer);

        System.out.println();
        System.out.println(DFS2(N));
    }

    public static void DFS(int N) {
        if (N==1) {
            return;
        } else {
            answer *= N;
            DFS(N-1);
        }
    }

    public static int DFS2(int N) {
        if (N==1) {
            return 1;
        } else {
            return N * DFS2(N-1);
        }
    }
}
