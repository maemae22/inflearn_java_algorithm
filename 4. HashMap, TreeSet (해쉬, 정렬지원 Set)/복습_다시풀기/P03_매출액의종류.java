package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P03_매출액의종류 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<K; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        sb.append(map.size()).append(" ");

        for (int rt=K; rt<N; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0)+1);
            if (map.get(arr[rt-K])==1) {
                map.remove(arr[rt-K]);
            } else {
                map.put(arr[rt-K], map.get(arr[rt-K])-1);
            }

            sb.append(map.size()).append(" ");
        }

        System.out.println(sb.toString());
    }
}
