import java.util.*;
import java.io.*;

/*
현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.
현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.
기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.
만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.
(출력) 첫 줄에 K번째 수를 출력합니다. K번째 수가 존재하지 않으면 -1를 출력합니다.
ex.
10 3
13 15 34 23 45 65 33 11 26 42
-> 143
 */
public class P05_K번째큰수 {

    // 방법1. 오름차순으로 풀기
    public static void main(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 로직
        TreeSet<Integer> sums = new TreeSet<>(); // 기본 오름차순 정렬
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                for (int k=0; k<N; k++) {
                    if (i!=j && j!=k && k!=i) {
                        sums.add( arr[i] + arr[j] + arr[k] );
                    }
                }
            }
        }

        // 출력 (sums에 있는 수 중에 K번째 큰 값 출력하기 !)
        int[] result = new int[sums.size()];
        int index = result.length-1;
        for (int sum : sums) {
            result[index] = sum;
            index--;
        }

        if (sums.size() < K) {
            System.out.println("-1");
        } else {
            System.out.println(result[K-1]);
        }
    }

    // 방법2. 내림차순으로 풀기
    public static void main2(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 로직
        TreeSet<Integer> sums = new TreeSet<>(Collections.reverseOrder()); // 내림차순 정렬
        for (int i=0; i<N; i++) {
            for (int j=i+1; j<N; j++) {
                for (int k=j+1; k<N; k++) {
                    sums.add( arr[i] + arr[j] + arr[k] );
                }
            }
        }

        // 출력 (sums에 있는 수 중에 K번째 큰 값 출력하기 !)
        int count = 0;
        int answer = -1;
        for (int sum : sums) {
//            System.out.println(sum);
            count++;
            if (count == K) {
                answer = sum;
            }
        }

        System.out.println(answer);

        /*
        // cf. 그 외 TreeSet의 유용한 메서드

        sums.remove(143);
        System.out.println(sums.size());
        System.out.println("first : " + sums.first()); // 오름차순일 경우 최솟값, 내림차순일 경우 최댓값.
        System.out.println("last : " + sums.last()); // 오름차순일 경우 최댓값, 내림차순일 경우 최솟값.

         */
    }
}
