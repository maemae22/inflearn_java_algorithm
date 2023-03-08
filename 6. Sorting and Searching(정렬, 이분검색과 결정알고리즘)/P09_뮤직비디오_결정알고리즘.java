import java.util.*;
import java.io.*;

/*
DVD에는 총 N개의 곡이 들어가는데, DVD에 녹화할 때에는 라이브에서의 순서가 그대로 유지되어야 한다.
즉, 1번 노래와 5번 노래를 같은 DVD에 녹화하기 위해서는 1번과 5번 사이의 모든 노래도 같은 DVD에 녹화해야 한다.
또한 한 노래를 쪼개서 두 개의 DVD에 녹화하면 안된다.
지니레코드 입장에서는 이 DVD가 팔릴 것인지 확신할 수 없기 때문에 이 사업에 낭비되는 DVD를 가급적 줄이려고 한다.
고민 끝에 지니레코드는 M개의 DVD에 모든 동영상을 녹화하기로 하였다. 이 때 DVD의 크기(녹화 가능한 길이)를 최소로 하려고 한다.
그리고 M개의 DVD는 모두 같은 크기여야 제조원가가 적게 들기 때문에 꼭 같은 크기로 해야 한다.
- 입력 : 첫째 줄에 자연수 N(1≤N≤1,000), M(1≤M≤N)이 주어진다.
        다음 줄에는 조영필이 라이브에서 부른 순서대로 부른 곡의 길이가 분 단위로(자연수) 주어진다.
- 출력 : 첫 번째 줄부터 DVD의 최소 용량 크기를 출력하세요.
ex.
9 3
1 2 3 4 5 6 7 8 9
-> 17 ( 설명 : 3개의 DVD용량이 17분짜리이면 (1, 2, 3, 4, 5) (6, 7), (8, 9) 이렇게 3개의 DVD로 녹음을 할 수 있다.
               17분 용량보다 작은 용량으로는 3개의 DVD에 모든 영상을 녹화할 수 없다. )
 */
public class P09_뮤직비디오_결정알고리즘 {
    public static void main(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int total = 0;
        int max = 0;
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
            max = Math.max(max, arr[i]);
        }

        // 로직
        int answer = 0;

        int lt = max;
        int rt = total;
        while (lt <= rt) {
            int mid = (lt+rt) / 2;
            if (canPut(arr, M, mid)) {
                answer = mid;
                rt = mid-1;
            } else {
                lt = mid+1;
            }
        }

        // 출력
        System.out.println(answer);
    }

    // arr 배열이 있을 때, DVD 용량이 size면 M개의 DVD에 담을 수 있는지 없는지 판별해서 알려주는 메서드
    // 가능하면 true, 불가능하면 false를 리턴함.
    public static boolean canPut(int[] arr, int M, int size) {
        int count = 1; // 몇 개의 DVD가 필요한지 count.
        int one = 0; // 한 묶음의 용량을 더해서 구함

        for (int song : arr) {
            one += song;
            if (one > size) {
                count++;
                one = song;
            }
        }

        if (count <= M) {
            return true;
        } else {
            return false;
        }
    }

}
