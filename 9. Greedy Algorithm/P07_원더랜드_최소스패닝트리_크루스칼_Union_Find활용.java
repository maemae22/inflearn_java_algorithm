import java.util.*;
import java.io.*;

/*
원더랜드에 문제가 생겼다. 원더랜드의 각 도로를 유지보수하는 재정이 바닥난 것이다.
원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지 도로는 폐쇄하려고 한다.
첫째 줄에 도시의 개수 V(1≤V≤100)와 도로의 개수 E(1≤E≤1,000)가 주어진다.
다음 E개의 줄에는 각 도로에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다.
이는 A번 도시와 B번 도시가 유지비용이 C인 도로로 연결되어 있다는 의미이다.
모든 도시를 연결하면서 드는 최소비용을 출력한다.
ex.
9 12
1 2 12
1 9 25
2 3 10
2 8 17
2 9 8
3 4 18
3 7 55
4 5 44
5 6 60
5 7 38
7 8 35
8 9 15
->
196
 */
public class P07_원더랜드_최소스패닝트리_크루스칼_Union_Find활용 {

    static int[] unf;

    public static void main(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        ArrayList<Edge> list = new ArrayList<>();
        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.add(new Edge(num1, num2, cost));
        }

        // 로직
        unf = new int[V+1];
        for (int i=0; i<=V; i++) {
            unf[i] = i;
        }

        Collections.sort(list);

        int sum = 0;
        for (Edge tmp : list) {
            if (Find(tmp.num1) != Find(tmp.num2)) {
                Union(tmp.num1, tmp.num2);
                sum += tmp.cost;
            }
        }

        // 출력
        System.out.println(sum);
    }

    // 같은 집합인지, 서로소인지 판별하는 함수
    public static int Find(int num) {
        if (unf[num] == num) {
            return num;
        } else {
            return unf[num] = Find(unf[num]);
        }
    }

    // 같은 집합으로 합쳐주는 함수
    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa!=fb) {
            unf[fa] = fb;
        }
    }
}

class Edge implements Comparable<Edge> {
    int num1;
    int num2;
    int cost;

    public Edge (int num1, int num2, int cost) {
        this.num1 = num1;
        this.num2 = num2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
