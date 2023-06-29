package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P15_피자배달거리_삼성SW역량평가기출문제_DFS활용 {

    static int N, M;
    static int answer = Integer.MAX_VALUE;
    static ArrayList<Address> homes = new ArrayList<>();
    static ArrayList<Address> stores = new ArrayList<>();
    static int[] choices;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num==1) {
                    homes.add(new Address(i, j));
                } else if (num==2) {
                    stores.add(new Address(i, j));
                }
            }
        }

        choices = new int[M];
        DFS(0, 0);

        System.out.println(answer);
    }

    public static void DFS(int level, int min) {
        if (level==M) {
            int cityDistance = cityDistance(choices); // 도시의 피자 배달 거리
            answer = Math.min(answer, cityDistance);
        } else {
            for (int i=min; i<stores.size(); i++) {
                choices[level] = i;
                DFS(level+1, i+1);
            }
        }
    }

    // 도시의 피자 배달 거리
    public static int cityDistance(int[] choices) {
        int total = 0;
        for (int i=0; i<homes.size(); i++) {
            total += oneDistance(homes.get(i), choices);
        }
        return total;
    }

    // 한 집의 피자 배달 거리
    public static int oneDistance(Address home, int[] choices) {
        int distance = Integer.MAX_VALUE;
        for (int i=0; i<M; i++) {
            int absX = Math.abs(home.x-stores.get(choices[i]).x);
            int absY = Math.abs(home.y-stores.get(choices[i]).y);
            distance = Math.min(distance, absX+absY);
        }
        return distance;
    }
}

class Address {
    int x;
    int y;
    Address(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
