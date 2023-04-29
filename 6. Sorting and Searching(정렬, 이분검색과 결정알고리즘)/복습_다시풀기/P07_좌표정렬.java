package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P07_좌표정렬 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Dot> list = new ArrayList<>();

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Dot(x, y));
        }

        Collections.sort(list);

        for (Dot dot : list) {
            System.out.println(dot.x+" "+dot.y);
        }
    }

}

class Dot implements Comparable<Dot> {
    int x;
    int y;

    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Dot o) {
        if (this.x==o.x) {
            return this.y - o.y;
        } else {
            return this.x - o.x;
        }
    }
}
