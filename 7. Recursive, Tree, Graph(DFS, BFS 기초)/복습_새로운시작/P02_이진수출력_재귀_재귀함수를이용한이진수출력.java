package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P02_이진수출력_재귀_재귀함수를이용한이진수출력 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        DFS(N);
    }

    public static void DFS(int N) {
        if (N==0) {
            return;
        }
        DFS(N/2);
        System.out.print(N%2);
    }
}
