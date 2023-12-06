package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P01_큰수출력하기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int pri = 0;
        int now = 0;
        while (st.hasMoreTokens()) {
            now = Integer.parseInt(st.nextToken());
            if (pri<now) {
                System.out.print(now+" ");
            }
            pri = now;
        }
    }
}
