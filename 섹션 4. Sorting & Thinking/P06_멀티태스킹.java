import java.util.*;

public class P06_멀티태스킹 {
    public int solution(int[] tasks, long k) {
        int count = tasks.length;
        int[] copy = new int[tasks.length+1];
//        System.arraycopy(tasks, 0, copy, 1, tasks.length);
        for (int i=1; i<copy.length; i++) {
            copy[i] = tasks[i-1];
        }
        Arrays.sort(copy);

        int index = -1;
        long restK = k;
        for (int i=1; i<copy.length; i++) {
            long require = (copy[i] - copy[i-1]) * (long)count;
            if (restK - require < 0) {
                index = i-1;
                break;
            }
            restK -= require;
            count--;
        }

        if (index==-1) {
            return -1;
        }

        long find = restK % count;
        return (int) find+index+1;
    }

    public static void main(String[] args) {
        P06_멀티태스킹 T = new P06_멀티태스킹();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}
