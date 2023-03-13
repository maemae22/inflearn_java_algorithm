import java.util.*;
import java.io.*;

/*
N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때
두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면 ”NO"를 출력하는 프로그램을 작성하세요.
둘로 나뉘는 두 부분집합은 서로소 집합이며, 두 부분집합을 합하면 입력으로 주어진 원래의 집합이 되어 합니다.
예를 들어 {1, 3, 5, 6, 7, 10}이 입력되면 {1, 3, 5, 7} = {6, 10} 으로 두 부분집합의 합이 16으로 같은 경우가 존재하는 것을 알 수 있다.
ex.
6
1 3 5 6 7 10
-> YES
 */
public class P01_합이같은부분집합_DFS_아마존인터뷰 {

    static int total;
    static int[] arr;
    static String answer = "NO";
    static int sum;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        total = 0;
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        int index = 0;
        sum = 0;

//        DFS(index);
        DFSDFS(index, 0);
        System.out.println(answer);
    }

    // 방법1.
    public static void DFS(int index) {
        if (sum*2 > total || index==N) {
            return;
        } else {
            sum += arr[index];
            if (sum*2 == total) {
                answer = "YES";
                return;
            }
            DFS(index+1);

            sum -= arr[index];
            DFS(index+1);
        }
    }

    // 방법2. (코드 훨씬 깔끔함 ..!)
    static boolean flag = false;

    public static void DFSDFS(int index, int summ) {
        if (flag) {
            return;
        }

        if (summ*2 > total) {
            return;
        }

        if (index == N) {
            if (summ*2 == total) {
                answer = "YES";
                flag = true;
            }
        } else {
            DFSDFS(index+1, summ+arr[index]);
            DFSDFS(index+1, summ);
        }
    }

}
