import java.util.*;
import java.io.*;

/*
현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.
현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
송아지는 움직이지 않고 제자리에 있다.
현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요.
입력 : 첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000까지이다.
출력 : 점프의 최소횟수를 구한다. 답은 1이상이며 반드시 존재합니다.
ex. 5 14 -> 3
 */
public class P08_송아지찾기1_BFS_상태트리탐색 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int go = E-S;
        System.out.println(calculate(go));
    }

    // 방법1. 직접 계산
    public static int calculate(int go) {
        if (go<0) {
            return Math.abs(go);
        } else { // go>0 (문제에서 go==0 인 상황은 주어지지 않는다.)
            int count = go / 5;
            int rest = go%5;
            if (rest == 1) {
                count += 1;
            } else if (rest == 2 || rest ==4) {
                count += 2;
            } else if (rest == 3) {
                count += 3;
            }
            return count;
        }
    }
}
