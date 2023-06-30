package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P02_회의실배정 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Time> list = new ArrayList<>();
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Time(start, end));
        }

        Collections.sort(list);

        int answer = 1;
        int priEnd = list.get(0).end;
        for (int i=1; i<N; i++) {
            if (list.get(i).start >= priEnd) {
                answer++;
                priEnd = list.get(i).end;
            }
        }

        System.out.println(answer);
    }
}

class Time implements Comparable<Time> {
    int start;
    int end;
    Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {
        if (this.end == o.end) {
            return this.start - o.start;
        } else {
            return this.end - o.end;
        }
    }
}
