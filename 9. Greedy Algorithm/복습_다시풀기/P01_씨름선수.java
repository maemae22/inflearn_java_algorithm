package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P01_씨름선수 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] heights = new int[N];
        int[] weights = new int[N];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            heights[i] = height;
            weights[i] = weight;
        }

        int answer = 0;
        for (int i=0; i<N; i++) {
            boolean pick = true;
            for (int j=0; j<N; j++) {
                if (heights[j]>heights[i] && weights[j]>weights[i]) {
                    pick = false;
                    break;
                }
            }
            if (pick) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
