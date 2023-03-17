import java.util.*;
import java.io.*;

/*
N×N 크기의 도시지도가 있습니다. 도시지도는 1×1크기의 격자칸으로 이루어져 있습니다.
각 격자칸에는 0은 빈칸, 1은 집, 2는 피자집으로 표현됩니다. 각 격자칸은 좌표(행번호, 열 번호)로 표현됩니다.
행번호는 1번부터 N번까지이고, 열 번호도 1부터 N까지입니다.
도시에는 각 집마다 “피자배달거리”가 았는데 각 집의 피자배달거리는 해당 집과 도시의 존재하는
피자집들과의 거리 중 최소값을 해당 집의 “피자배달거리”라고 한다.
집과 피자집의 피자배달거리는 |x1-x2|+|y1-y2| 이다.
예를 들어, (1, 2)에 있는 집과 (2, 3)에 있는 피자집과의 피자 배달 거리는 |1-2| + |2-3| = 2가 된다.
최근 도시가 불경기에 접어들어 우후죽순 생겼던 피자집들이 파산하고 있습니다.
도시 시장은 도시에 있는 피자집 중 M개만 살리고 나머지는 보조금을 주고 폐업시키려고 합니다.
시장은 살리고자 하는 피자집 M개를 선택하는 기준으로 도시의 피자배달거리가 최소가 되는 M개의 피자집을 선택하려고 합니다.
도시의 피자 배달 거리는 각 집들의 피자 배달 거리를 합한 것을 말합니다.
입력 : 첫째 줄에 N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 12)이 주어진다. 둘째 줄부터 도시 정보가 입력된다.
출력 : 첫째 줄에 M개의 피자집이 선택되었을 때 도시의 최소 피자배달거리를 출력한다.
ex.
4 4
0 1 2 0
1 0 2 1
0 2 1 2
2 0 1 2
->
6
 */
public class P15_피자배달거리_삼성SW역량평가기출문제_DFS활용 {

    static int N, M;
    static int answer = Integer.MAX_VALUE;
    static int[][] arr;
    static ArrayList<Points> homes = new ArrayList<>();
    static ArrayList<Points> stores = new ArrayList<>();
    static int[] select;

    public static void main(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 1) {
                    homes.add(new Points(i, j));
                } else if (arr[i][j] == 2) {
                    stores.add(new Points(i, j));
                }
            }
        }

        // 로직
        select = new int[M];
        DFS(0, 0);

        // 출력
        System.out.println(answer);
    }

    public static void DFS(int index, int min) {
        if (index == M) {
            answer = Math.min(answer, disSumBetweenHomesAndStores(select));
        } else {
            for (int i=min; i<stores.size(); i++) {
                select[index] = i;
                DFS(index+1, i+1);
            }
        }
    }

    public static int disSumBetweenHomesAndStores (int[] select) {
        int sum = 0;
        for (int i=0; i<homes.size(); i++) {
            int dis = Integer.MAX_VALUE;
            Points home = homes.get(i);
            for (int j=0; j<select.length; j++) {
                Points store = stores.get(select[j]);
                dis = Math.min(dis, Math.abs(home.x - store.x) + Math.abs(home.y - store.y));
            }
            sum+=dis;
        }
        return sum;
    }
}

class Points {
    int x;
    int y;

    public Points(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
