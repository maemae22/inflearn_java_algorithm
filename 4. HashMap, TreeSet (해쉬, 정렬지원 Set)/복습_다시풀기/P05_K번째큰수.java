package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P05_K번째큰수 {

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

        HashSet<Integer> set = new HashSet<>();

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                for (int k=0; k<N; k++) {
                    if (i!=j && j!=k && i!=k) {
                        set.add(arr[i]+arr[j]+arr[k]);
                    }
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : set) {
            list.add(num);
        }
        Collections.sort(list, Collections.reverseOrder());

        if (list.size() < K) {
            System.out.println("-1");
        } else {
            System.out.println(list.get(K-1));
        }
    }
}
