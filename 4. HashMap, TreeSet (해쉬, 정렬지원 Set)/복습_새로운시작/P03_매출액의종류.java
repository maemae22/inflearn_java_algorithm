package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P03_매출액의종류 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<K; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        int now = map.size();
        System.out.print(now+" ");

        for (int i=K; i<N; i++) {
            map.put(arr[i-K], map.get(arr[i-K])-1);
            if (map.get(arr[i-K])==0) {
                now--;
            }

            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            if (map.get(arr[i])==1) {
                now++;
            }

            System.out.print(now+" ");
        }
    }
}
