import java.util.*;
import java.io.*;

/*
10이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
입력 : 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다. 두 번째 줄에 N개의 자연수가 오름차순으로 주어집니다.
출력 : 첫 번째 줄에 결과를 출력합니다. 출력순서는 사전순으로 오름차순으로 출력합니다.
ex.
3 2
3 6 9
->
3 6
3 9
6 3
6 9
9 3
9 6
 */
public class P06_순열구하기 {

    static int N, M;
    static int[] arr;
    static int[] answer;
    static int[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        check = new int[11];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            check[arr[i]] = 1;
        }

        answer = new int[M];
        DFS(0);
    }

    public static void DFS(int level) {
        if (level == M) {
            for (int num : answer) {
                System.out.print(num+" ");
            }
            System.out.println();
        } else {
            for (int i=0; i<N; i++) {
                if (check[arr[i]]==1) {
                    answer[level] = arr[i];
                    check[arr[i]] = 0;
                    DFS(level+1);
                    check[arr[i]] = 1;
                }
            }
        }
    }
}
