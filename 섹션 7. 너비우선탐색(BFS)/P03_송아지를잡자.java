import java.util.*;

public class P03_송아지를잡자 {
    public int solution(int s, int e) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);

        int now = e;
        int go = 1;

        int answer = 1;
        while (now<=200000 && !q.isEmpty()) {
            int size = q.size();
            now += go;
            go++;
            int[] check = new int[200001];
            for (int i=0; i<size; i++) {
                int tmp = q.poll();
                int[] next = {tmp+1, tmp-1, tmp*2};
                for (int nx : next) {
                    if (nx==now) {
                        return answer;
                    }
                    if (0<=nx && nx<=200000 && check[nx]==0) {
                        check[nx]=1;
                        q.offer(nx);
                    }
                }
            }
            answer++;
        }

        return -1;
    }

    public static void main(String[] args) {
        P03_송아지를잡자 T = new P03_송아지를잡자();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}
