import java.util.*;
import java.io.*;

/*
오늘은 새 학기 새로운 반에서 처음 시작하는 날이다. 현수네 반 학생은 N명이다. 현수는 각 학생들의 친구관계를 알고 싶다.
모든 학생은 1부터 N까지 번호가 부여되어 있고, 현수에게는 각각 두 명의 학생의 친구 관계가 번호로 표현된 숫자쌍이 주어진다.
만약 (1, 2), (2, 3), (3, 4)의 숫자쌍이 주어지면 1번 학생과 2번 학생이 친구이고, 2번 학생과 3번 학생이 친구, 3번 학생과 4번 학생이 친구이다.
그리고 1번 학생과 4번 학생은 2번과 3번을 통해서 친구관계가 된다.
학생의 친구관계를 나타내는 숫자쌍이 주어지면 특정 두 명이 친구인지를 판별하는 프로그램을 작성하세요.
두 학생이 친구이면 “YES"이고, 아니면 ”NO"를 출력한다.
입력 : 첫 번째 줄에 반 학생수인 자연수 N(1<=N<=1,000)과 숫자쌍의 개수인 M(1<=M<=3,000)이 주어지고, 다음 M개의 줄에 걸쳐 숫자쌍이 주어진다.
       마지막 줄에는 두 학생이 친구인지 확인하는 숫자쌍이 주어진다.
ex.
9 7
1 2
2 3
3 4
1 5
6 7
7 8
8 9
3 8
->
NO
 */
// 서로소 집합 구분하기 !
public class P06_친구인가_Disjoint_Set_Union_Find {

    static int[] unf;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        unf = new int[N+1];
        for (int i=0; i<=N; i++) {
            unf[i] = i;
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Union(a, b);
        }

        st = new StringTokenizer(br.readLine());
        int find1 = Integer.parseInt(st.nextToken());
        int find2 = Integer.parseInt(st.nextToken());

        if (Find(find1) == Find(find2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static int Find(int num) {
        if (num == unf[num]) {
            return num;
        } else {
            return unf[num] = Find(unf[num]);
        }
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa!=fb) {
            unf[fa] = fb;
        }
    }

}
