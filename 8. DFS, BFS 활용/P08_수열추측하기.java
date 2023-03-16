import java.util.*;
import java.io.*;

/*
가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀 있다. 그리고 둘째 줄부터 차례대로 파스칼의 삼각형처럼 위의 두개를 더한 값이 저장되게 된다.
예를 들어 N이 4 이고 가장 윗 줄에 3 1 2 4 가 있다고 했을 때, 다음과 같은 삼각형이 그려진다.
3 1 2 4
 4 3 6
  7 9
   16
N과 가장 밑에 있는 숫자가 주어져 있을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하시오.
단, 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력하여야 한다.
입력 : 첫째 줄에 두개의 정수 N(1≤N≤10)과 F가 주어진다.
       N은 가장 윗줄에 있는 숫자의 개수를 의미하며 F는 가장 밑에 줄에 있는 수로 1,000,000 이하이다.
출력 : 첫째 줄에 삼각형에서 가장 위에 들어갈 N개의 숫자를 빈 칸을 사이에 두고 출력한다. 답이 존재하지 않는 경우는 입력으로 주어지지 않는다.
ex. 4 16 -> 3 1 2 4
 */
public class P08_수열추측하기 {

    static int N, F;
    static int[][] arr;
    static int[] check, answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        check = new int[N+1];
        answer = new int[N];

        Combi(N, N);
        DFS(0, 0);
    }

    static boolean flag = false;
    public static void DFS(int index, int sum) {
        if (flag) {
            return;
        }
        if (sum > F) {
            return;
        }
        if (index == N) {
            if (sum == F) {
                for (int num : answer) {
                    System.out.print(num + " ");
                }
                flag = true;
            }
        } else {
            for (int i=1; i<=N; i++) {
                if (check[i] == 0) {
                    answer[index] = i;
                    check[i] = 1;
                    DFS(index+1, sum+i*Combi(N-1, index));
                    check[i] = 0;
                }
            }
        }
    }

    public static int Combi(int n, int r) {
        if (n==r || r==0) {
            return 1;
        }
        if (r==1) {
            return n;
        }
        if (arr[n][r]!=0) {
            return arr[n][r];
        }
        return arr[n][r] = Combi(n-1, r-1) + Combi(n-1, r);
    }
}
