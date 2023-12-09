package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P01_재귀함수_스택프레임 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        DFS(N);
    }

    public static void DFS(int N) {
        if (N==0) {
            return;
        }
        DFS(N-1);
        System.out.print(N+" ");
    }
}
