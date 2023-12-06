package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P06_뒤집은소수 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] sosu = new int[100001]; // sosu[i]==0 이면, i는 소수이다 !
        sosu[0]=1;
        sosu[1]=1;
        for (int i=2; i<sosu.length; i++) {
            if (sosu[i]==0) {
                for (int j=i*2; j<sosu.length; j=j+i) {
                    sosu[j]++;
                }
            }
        }

        for (int i=0; i<N; i++) {
            String reverse = new StringBuilder(st.nextToken()).reverse().toString();
            int num = Integer.parseInt(reverse);
            if (sosu[num]==0) {
                System.out.print(num+" ");
            }
        }
    }
}
