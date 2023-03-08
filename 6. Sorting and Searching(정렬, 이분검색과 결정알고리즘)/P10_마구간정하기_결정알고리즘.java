import java.util.*;
import java.io.*;

/*
N개의 마구간이 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마구간간에 좌표가 중복되는 일은 없습니다.
현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다. 각 마구간에는 한 마리의 말만 넣을 수 있고,
가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.
C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램을 작성하세요.
출력 : 첫 줄에 가장 가까운 두 말의 최대 거리를 출력하세요.
ex.
5 3
1 2 8 4 9
-> 3
 */
public class P10_마구간정하기_결정알고리즘 {

    public static void main(String[] args) throws Exception {
        // 초기세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 로직
        int[] between = new int[N-1];
        for (int i=0; i<N-1; i++) {
            between[i] = arr[i+1] - arr[i];
        }

        // ⭐ 결정 알고리즘
        int answer = 0;
        int lt = Arrays.stream(between).min().getAsInt();
        int rt = Arrays.stream(between).sum();

        while (lt <= rt) {
            int mid = (lt+rt) / 2;
            if (canPut(between, mid, C)) {
                answer = mid;
                lt = mid+1;
            } else {
                rt = mid-1;
            }
        }

        // 출력
        System.out.println(answer);
    }

    // 마구간의 좌표 간격 배열(betweens)이 주어졌을 때, 최소 between 만큼의 간격으로 C 마리의 말을 넣을 수 있는지 판별하는 메서드
    // 가능하면 true, 불가능하면 false를 반환한다.
    // = betweens 배열을 최소 between의 숫자가 들어가게 나눴을 때, C-1개 이상의 묶음이 나오면 참, 아니면 거짓이 된다.
    public static boolean canPut(int[] betweens, int between, int C) {
        int count = 0; // 총 몇 묶음이 나오는지
        int one = 0; // 한 묶음

        for (int tmp : betweens) {
            one += tmp;
            if (one >= between) {
                count++;
                one = 0;
            }
        }

        if (count >= C-1) {
            return true;
        } else {
            return false;
        }
    }

}
