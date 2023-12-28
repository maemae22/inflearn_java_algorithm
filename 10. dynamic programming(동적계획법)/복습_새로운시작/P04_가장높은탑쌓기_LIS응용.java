package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P04_가장높은탑쌓기_LIS응용 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Brick> list = new ArrayList<>();
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Brick(a, b, c));
        }

        Collections.sort(list);
        int[] dy = new int[N];
        int answer = 0;
        for (int i=0; i<N; i++) {
            Brick tmp = list.get(i);
            int max = tmp.b;
            for (int j=0; j<i; j++) {
                Brick one = list.get(j);
                if (one.c<tmp.c) {
                    max = Math.max(max, dy[j]+tmp.b);
                }
            }
            dy[i] = max;
            answer = Math.max(answer, dy[i]);
        }

        System.out.println(answer);
    }
}

class Brick implements Comparable<Brick> {
    int a;
    int b;
    int c;
    Brick(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int compareTo(Brick o) {
        return this.a - o.a;
    }
}
