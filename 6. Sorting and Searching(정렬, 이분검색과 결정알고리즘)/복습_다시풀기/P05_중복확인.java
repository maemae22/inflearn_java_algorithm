package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P05_중복확인 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean duplicate = false;
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (set.contains(num)) {
                duplicate = true;
                break;
            } else {
                set.add(num);
            }
        }

        if (duplicate) {
            System.out.println("D");
        } else {
            System.out.println("U");
        }
    }
}
