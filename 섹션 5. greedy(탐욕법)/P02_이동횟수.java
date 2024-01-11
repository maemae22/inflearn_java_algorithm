import java.util.*;

public class P02_이동횟수 {
    public int solution(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);
        int lt = 0;
        int rt = nums.length-1;
        while (lt<=rt) {
            int remain = 5;
            while (rt>=0 && remain-nums[rt]>=0) {
                remain -= nums[rt];
                rt--;
            }
            while (lt<nums.length && remain-nums[lt]>=0) {
                remain -= nums[lt];
                lt++;
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        P02_이동횟수 T = new P02_이동횟수();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }
}
