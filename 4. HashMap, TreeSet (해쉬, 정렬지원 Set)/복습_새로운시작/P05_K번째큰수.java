package 복습_새로운시작;

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
                    if (i!=j && i!=k && j!=k) {
                        set.add(arr[i]+arr[j]+arr[k]);
                    }
                }
            }
        }

        if (set.size()<K) {
            System.out.println("-1");
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            for (int tmp : set) {
                list.add(tmp);
            }
            Collections.sort(list, Collections.reverseOrder());

            System.out.println(list.get(K-1));
        }
    }
}
