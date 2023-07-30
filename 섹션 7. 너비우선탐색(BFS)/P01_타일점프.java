import java.util.*;

public class P01_타일점프 {
    public int solution(int[] nums) {

        return BFS(nums);
    }

    public int BFS(int[] nums) {
        int target = nums.length-1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        int answer = -1;
        int count = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int k=0; k<size; k++) {
                int tmp = q.poll();
                for (int i=1; i<=nums[tmp]; i++) {
                    if (tmp+i==target) {
                        return count+1;
                    }
                    q.offer(tmp+i);
                }
            }
            count++;
//            System.out.println(count+"="+q);
        }

        return answer;
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