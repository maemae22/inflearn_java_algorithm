import java.util.*;
import java.io.*;

/*
현수의 아빠는 제과점을 운영합니다.
현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를 각 구간별로 구하라고 했습니다.
N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별 매출액의 종류를 출력하는 프로그램을 작성하세요.
ex.
7 4
20 12 20 10 23 17 10
-> 3 4 4 3
 */
public class P03_매출액의종류 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        TreeSet<Integer> set = new TreeSet<>();
        HashMap<Integer, Integer> duplicate = new HashMap<>();
        for (int i=0; i<K; i++) {
            if (set.contains(arr[i])) { // 이미 있는 숫자라면,
                duplicate.put(arr[i], duplicate.getOrDefault(arr[i], 0)+1);
            } else {
                set.add(arr[i]);
            }
        }

        sb.append(set.size()+" ");

        int lt = 0;
        for (int rt=K; rt<N; rt++) {

            // lt 제거
            if (!duplicate.containsKey(arr[lt]) || duplicate.get(arr[lt])==0 ) {
                set.remove(arr[lt]);
                lt++;
            } else { // 중복되어 있는 것이 맞다면, map에서 중복 count만 줄여줌 .. !
                duplicate.put(arr[lt], duplicate.get(arr[lt])-1 );
                lt++;
            }

            // rt 추가
            if (set.contains(arr[rt])) { // 이미 있는 숫자라면,
                duplicate.put(arr[rt], duplicate.getOrDefault(arr[rt], 0)+1);
            } else {
                set.add(arr[rt]);
            }

            sb.append(set.size()+" ");

//            System.out.println("lt = "+lt+", rt = "+rt+" / set.size() = "+set.size());
//            System.out.println(set);
        }

        System.out.println(sb.toString());
    }
}
