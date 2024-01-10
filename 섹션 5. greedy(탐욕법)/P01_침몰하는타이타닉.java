import java.util.*;

public class P01_침몰하는타이타닉 {
    public int solution(int[] nums, int m) {
        Arrays.sort(nums);
        int lt = 0;
        int rt = nums.length-1;
        int answer = 0;
        while (lt<rt) {
            if (nums[lt]+nums[rt]<=m) {
                answer++;
                lt++;
                rt--;
            } else {
                answer++;
                rt--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P01_침몰하는타이타닉 T = new P01_침몰하는타이타닉();
        System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(T.solution(new int[]{86, 95, 107, 67, 38, 49, 116, 22, 78, 53}, 150));
        System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
        System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
    }
}
