package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P01_계단오르기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(stair(N));
    }

    public static int stair(int N) {
        if (N==0 || N==1) {
            return 1;
        } else {
            return stair(N-2) + stair(N-1);
        }
    }
}
