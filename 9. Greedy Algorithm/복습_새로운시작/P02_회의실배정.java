package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P02_회의실배정 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Time> list = new ArrayList<>();
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        int answer = 0;
        int end = 0;
        for (int i=0; i<N; i++) {
            if (end<=list.get(i).start) {
                boolean pick = true;
                for (int j=i+1; j<N && list.get(i).end>list.get(j).start; j++) {
                    if (list.get(j).end<=list.get(i).end) {
                        pick = false;
                        break;
                    }
                }
                if (pick) {
                    answer++;
                    end = list.get(i).end;
                }
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
        return this.start!=o.start ? this.start-o.start : this.end-o.end;
    }
}
