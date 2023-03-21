import java.util.*;
import java.io.*;

/*
철수는 계단을 오를 때 한 번에 한 계단 또는 두 계단씩 올라간다. 만약 총 4계단을 오른다면 그 방법의 수는
1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2 로 5가지이다.
그렇다면 총 N계단일 때 철수가 올라갈 수 있는 방법의 수는 몇 가지인가?
ex. 7 -> 21
 */
public class P01_계단오르기 {

    static int answer;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        DFS(0);
        System.out.println(answer);
    }

    public static void DFS(int sum) {
        if (sum > N) {
            return;
        }

        if (sum == N) {
            answer++;
        } else {
            DFS(sum+1);
            DFS(sum+2);
        }
    }
}
