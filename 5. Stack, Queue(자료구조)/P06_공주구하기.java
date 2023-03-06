import java.util.*;
import java.io.*;

// N과 K가 주어질 때 공주를 구하러 갈 왕자의 번호를 출력하는 프로그램을 작성하시오.
// ex. 8 3 -> 7
public class P06_공주구하기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=N; i++) {
            queue.add(i);
        }

        // 방법1.
        int count = 0;

        while(queue.size()!=1) {
            if (count == K-1) {
                count = 0;
                queue.poll();
            } else {
                count++;
                queue.add(queue.poll());
            }
        }

        System.out.println(queue.poll());

        /*
        // 방법2.
        int answer = 0;

        while(!queue.isEmpty()) {
            for (int i=1; i<K; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
            if (queue.size()==1) {
                answer = queue.poll();
            }
        }

        System.out.println(answer);
         */

    }
}
