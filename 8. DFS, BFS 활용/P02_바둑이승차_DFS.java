import java.util.*;
import java.io.*;

/*
철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C킬로그램 넘게 태울수가 없다.
철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.
N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.
ex.
259 5
81
58
42
33
61
-> 242
 */
public class P02_바둑이승차_DFS {

    static int[] arr;
    static int N;
    static int C;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 로직 & 출력
        DFS(0, 0);

        System.out.println(answer);
    }

    public static void DFS(int index, int sum) {
        if (sum > C) {
            return;
        }

        if (index == N) {
            answer = Math.max(answer, sum);
            return;
        } else {
            DFS(index+1, sum+arr[index]);
            DFS(index+1, sum);
        }
    }
}
