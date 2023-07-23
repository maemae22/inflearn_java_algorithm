import java.util.*;

public class P01_최대길이연속수열 {
    public int solution(int[] nums) {
        Arrays.sort(nums);
        int answer = 0;
        int count = 1;
        int last = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i]==last+1) {
                count++;
            } else {
                answer = Math.max(answer, count);
                count = 1;
            }
            last = nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        P01_최대길이연속수열 T = new P01_최대길이연속수열();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
