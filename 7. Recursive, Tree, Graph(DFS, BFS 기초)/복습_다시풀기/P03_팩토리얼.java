package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P03_팩토리얼 {

    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        answer = 1;
        DFS(N);
        System.out.println(answer);
        System.out.println();
        System.out.println(Fact(N));
    }

    public static void DFS(int N) {
        if (N==1) {
            return;
        } else {
            DFS(N-1);
            answer *= N;
        }
    }

    public static int Fact(int N) {
        if (N==1) {
            return 1;
        } else {
            return N * Fact(N-1);
        }
    }
}
