import java.util.*;

public class P02_집으로이동 {
    public int solution(int[] pool, int a, int b, int home) {
        int[] plus = new int[10001];
        int[] minus = new int[10001];
        for (int tmp : pool) {
            plus[tmp]=1;
            minus[tmp]=1;
        }

        Queue<State> q = new LinkedList<>();
        q.offer(new State(0, '+'));
        plus[0]=1;
        minus[0]=1;
        int count = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                State tmp = q.poll();
                int nextPlus = tmp.now+a;
                if (nextPlus==home) {
                    return count+1;
                }
                if (0<=nextPlus && nextPlus<=10000 && plus[nextPlus]==0) {
                    plus[nextPlus]=1;
                    q.offer(new State(nextPlus, '+'));
                }
                int nextMinus = tmp.now-b;
                if (tmp.pri=='+' && 0<=nextMinus && nextMinus<=10000 && minus[nextMinus]==0) {
                    if (nextMinus==home) {
                        return count+1;
                    }
                    minus[nextMinus]=1;
                    q.offer(new State(nextMinus, '-'));
                }
            }
            count++;
        }

        return -1;
    }

    public static void main(String[] args) {
        P02_집으로이동 T = new P02_집으로이동();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}

class State {
    int now;
    char pri;
    State(int now, char pri) {
        this.now = now;
        this.pri = pri;
    }
}
