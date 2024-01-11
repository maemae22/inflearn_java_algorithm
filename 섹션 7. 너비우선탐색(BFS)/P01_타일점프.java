import java.util.*;

public class P01_타일점프 {
    public int solution(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int[] check = new int[nums.length];
        check[0]=1;

        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int tmp = q.poll();
                for (int j=1; j<=nums[tmp]; j++) {
                    int next = tmp+j;
                    if (nums.length-1<=next) {
                        return count+1;
                    }
                    if (check[next]==0) {
                        q.offer(next);
                        check[next]=1;
                    }
                }
            }
            count++;
        }

        return -1;
    }

    public static void main(String[] args) {
        P01_타일점프 T = new P01_타일점프();
        System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}
