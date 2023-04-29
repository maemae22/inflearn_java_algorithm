package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P08_응급실 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Queue<People> q = new LinkedList<>();
        Integer[] arr = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            q.offer(new People(i, tmp));
            arr[i] = tmp;
        }

        Arrays.sort(arr, Collections.reverseOrder());
        int index = 0;
        int answer = 1;

        while (!q.isEmpty()) {
            if (q.peek().danger == arr[index]) {
                People tmp = q.poll();
                if (tmp.index == M) {
                    break;
                } else {
                    index++;
                    answer++;
                }
            } else {
                q.offer(q.poll());
            }
        }

        System.out.println(answer);
    }
}

class People {
    int index;
    int danger;

    People(int index, int danger) {
        this.index = index;
        this.danger = danger;
    }
}
