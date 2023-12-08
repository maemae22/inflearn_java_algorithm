package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P04_LRU_LeastRecentlyUsed {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] tasks = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            tasks[i] = Integer.parseInt(st.nextToken());
        }

        int[] cpu = new int[S];
        HashSet<Integer> set = new HashSet<>();
        for (int tmp : tasks) {
            if (!set.contains(tmp)) {
                set.add(tmp);
                set.remove(cpu[S-1]);
                for (int i=S-1; i>0; i--) {
                    cpu[i] = cpu[i-1];
                }
            } else {
                int index = 0;
                for (int i=0; i<N; i++) {
                    if (cpu[i]==tmp) {
                        index = i;
                        break;
                    }
                }
                for (int j=index; j>0; j--) {
                    cpu[j] = cpu[j-1];
                }
            }
            cpu[0] = tmp;
        }

        for (int tmp : cpu) {
            System.out.print(tmp+" ");
        }
    }
}
