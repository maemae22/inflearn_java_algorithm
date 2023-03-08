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

}
