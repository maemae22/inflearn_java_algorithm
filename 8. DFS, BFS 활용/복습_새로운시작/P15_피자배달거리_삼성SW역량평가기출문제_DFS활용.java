package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P15_피자배달거리_삼성SW역량평가기출문제_DFS활용 {

    static int answer = Integer.MAX_VALUE;
    static int M;
    static ArrayList<Map> home = new ArrayList<>();
    static ArrayList<Map> pizza = new ArrayList<>();
    static int[] pick;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j]==1) {
                    home.add(new Map(i, j));
                } else if (arr[i][j]==2) {
                    pizza.add(new Map(i, j));
                }
            }
        }

        pick = new int[M];
        DFS(0, 0);
        System.out.println(answer);
    }

    public static void DFS(int index, int min) {
        if (index==M) {
            int sum = 0;
            for (Map tmp : home) {
                int dis = Integer.MAX_VALUE;
                for (int go : pick) {
                    Map store = pizza.get(go);
                    dis = Math.min(dis, Math.abs(tmp.x-store.x)+Math.abs(tmp.y-store.y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i=min; i<pizza.size(); i++) {
                pick[index]=i;
                DFS(index+1, i+1);
            }
        }
    }
}

class Map {
    int x;
    int y;
    Map(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
