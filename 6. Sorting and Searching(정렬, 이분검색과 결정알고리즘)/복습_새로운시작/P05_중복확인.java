package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P05_중복확인 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        if (set.size()==N) {
            System.out.println("U");
        } else {
            System.out.println("D");
        }
    }
}
