import java.util.*;
import java.io.*;

public class P05_최대길이바이토닉수열 {

    public static int solution(int[] nums) {

        ArrayList<Integer> peakIndexList = new ArrayList<>();
        for (int i=1; i<nums.length-1; i++) {
            if (nums[i-1]<nums[i] && nums[i]>nums[i+1]) {
                peakIndexList.add(i);
            }
        }
//        System.out.println(peakIndexList);

        int answer = 0;
        for (int peakIndex : peakIndexList) {
            int length = 1;
            for (int i=peakIndex; i>=1; i--) {
                if (nums[i-1]<nums[i]) {
                    length++;
                } else {
                    break;
                }
            }

            for (int i=peakIndex; i<=nums.length-2; i++) {
                if (nums[i]>nums[i+1]) {
                    length++;
                } else {
                    break;
                }
            }
            answer = Math.max(answer, length);
        }

        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1}));
        System.out.println(solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
        System.out.println(solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
    }
}
