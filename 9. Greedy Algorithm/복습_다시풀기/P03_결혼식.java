package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P03_결혼식 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Go> list = new ArrayList<>();
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int inTime = Integer.parseInt(st.nextToken());
            int outTime = Integer.parseInt(st.nextToken());
            list.add(new Go(inTime, 'i'));
            list.add(new Go(outTime, 'o'));
        }

        Collections.sort(list);

        int answer = 0;
        int now = 0;
        for (Go go : list) {
            if (go.status=='i') {
                now++;
            } else if (go.status=='o') {
                now--;
            }
            answer = Math.max(answer, now);
        }

        System.out.println(answer);
    }
}

class Go implements Comparable<Go> {
    int time;
    char status;
    Go (int time, char status) {
        this.time = time;
        this.status = status;
    }

    @Override
    public int compareTo(Go o) {
        return this.time!=o.time ? this.time-o.time : o.status-this.status;
    }
}
