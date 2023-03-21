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
public class P08_원더랜드_최소스패닝트리_프림_PriorityQueue {

    public static void main(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 인접리스트 만들기
        ArrayList<ArrayList<Edges>> list = new ArrayList<>();
        for (int i=0; i<=V; i++) {
            list.add(new ArrayList<Edges>());
        }

        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 무방향 그래프이기 때문에, 둘 다 만들어줌 !!
            list.get(num1).add(new Edges(num2, cost));
            list.get(num2).add(new Edges(num1, cost));
        }

        // 로직
        int[] check = new int[V+1];
        PriorityQueue<Edges> pQ = new PriorityQueue<>();
        int sum = 0;
        pQ.offer(new Edges(1, 0)); // '1번 정점으로 갈 때, 비용은 0이다' 라는 뜻 !

        while (!pQ.isEmpty()) {
            Edges tmp = pQ.poll();
            if (check[tmp.num] == 0) {
                check[tmp.num] = 1;
                sum += tmp.cost;
                for (Edges toadd : list.get(tmp.num)) {
                    if (check[toadd.num] == 0) {
                        pQ.offer(toadd);
                    }
                }
            }
        }

        // 출력
        System.out.println(sum);
    }
}

class Edges implements Comparable<Edges> {
    int num;
    int cost;

    public Edges (int num, int cost) {
        this.num = num;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edges o) {
        return this.cost - o.cost;
    }
}
