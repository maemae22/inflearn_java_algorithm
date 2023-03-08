import java.util.*;
import java.io.*;

/*
현수네 반에는 N명의 학생들이 있습니다.
선생님은 반 학생들에게 1부터 10,000,000까지의 자연수 중에서 각자가 좋아하는 숫자 하나 적어 내라고 했습니다.
만약 N명의 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D(duplication)를 출력하고,
N명이 모두 각자 다른 숫자를 적어냈다면 U(unique)를 출력하는 프로그램을 작성하세요.
ex.
8
20 25 52 30 39 33 43 33
-> D
 */
public class P05_중복확인 {

    // 방법1. TreeSet 사용 (1)
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeSet<Integer> set = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        if (set.size() == N) {
            System.out.println("U");
        } else {
            System.out.println("D");
        }
    }

    // 방법2. TreeSet 사용 (2)
    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeSet<Integer> set = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean duplicate = false;
        for (int i=0; i<N; i++) {
            int push = Integer.parseInt(st.nextToken());
            if (set.contains(push)) {
                System.out.println("D");
                duplicate = true;
                break;
            } else {
                set.add(push);
            }
        }

        if (!duplicate) {
            System.out.println("U");
        }
    }

    // 방법3. 정렬 이용 - O(nlogn)
    public static void main3(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 로직 (정렬 + 정렬 후 같은 것이 있는지 for문을 돌며 확인) : Arrays.sort(arr);
        String answer = "U";
        Arrays.sort(arr);

        for (int i=1; i<arr.length; i++) {
            if (arr[i] == arr[i-1]) {
                answer = "D";
                break;
            }
        }

        System.out.println(answer);
    }

}
