package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P06_친구인가_Disjoint_Set_Union_Find {

    static int[] group;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        group = new int[N+1];
        for (int i=1; i<=N; i++) {
            group[i] = i;
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        System.out.println(find(a)==find(b) ? "YES" : "NO");
    }

    public static void union(int a, int b) {
        if (find(a)!=find(b)) {
            group[find(a)] = find(b);
        }
    }

    public static int find(int a) {
        if (group[a]==a) {
            return a;
        } else {
            return group[a] = find(group[a]);
        }
    }
}
