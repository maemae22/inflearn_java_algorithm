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

    public int solution2(int s, int e) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        int[][] check = new int[2][200001];
        check[0][s]=1;

        int now = e;
        int go = 1;

        int answer = 1;
        while (now<=200000 && !q.isEmpty()) {
            int size = q.size();
            now += go;
            go++;

            for (int i=0; i<size; i++) {
                int tmp = q.poll();
                int[] next = {tmp+1, tmp-1, tmp*2};
                for (int nx : next) {
                    if (0<=nx && nx<=200000 && check[answer%2][nx]==0) {
                        check[answer%2][nx]=1;
                        q.offer(nx);
                    }
                }
            }
            if (check[answer%2][now]==1) {
                return answer;
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
        System.out.println();
        System.out.println(T.solution2(1, 11));
        System.out.println(T.solution2(10, 3));
        System.out.println(T.solution2(1, 34567));
        System.out.println(T.solution2(5, 6));
        System.out.println(T.solution2(2, 54321));
    }
}
