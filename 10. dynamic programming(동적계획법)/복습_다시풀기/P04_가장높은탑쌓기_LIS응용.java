package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P04_가장높은탑쌓기_LIS응용 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Block> list = new ArrayList<>();
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Block(a, b, c));
        }

        // size 내림차순 정렬
        Collections.sort(list);

        // dy[i] = List에서 i번째 블록이 제일 위에 왔을 때의 최대 높이
        int[] dy = new int[N];
        dy[0] = list.get(0).height;

        for (int i=1; i<N; i++) {
            int max = list.get(i).height;
            for (int j=0; j<i; j++) {
                if (list.get(j).weight > list.get(i).weight) {
                    max = Math.max(max, dy[j]+list.get(i).height);
                }
            }
            dy[i] = max;
        }

        int answer = 0;
        for (int tmp : dy) {
            answer = Math.max(answer, tmp);
        }
        System.out.println(answer);
    }
}

class Block implements Comparable<Block> {
    int size;
    int height;
    int weight;
    Block(int size, int height, int weight) {
        this.size = size;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Block o) {
        return o.size - this.size;
    }
}