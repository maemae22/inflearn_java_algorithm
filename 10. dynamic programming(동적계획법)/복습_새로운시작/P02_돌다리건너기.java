package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P02_돌다리건너기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dy = new int[N+2];
        dy[1]=1;
        dy[2]=2;
        for (int i=3; i<=N+1; i++) {
            dy[i] = dy[i-2] + dy[i-1];
        }

        System.out.println(dy[N+1]);
    }
}
