import java.util.*;

public class P02_수열찾기 {
    public int[] solution(int[] nums){
        List<Integer> list = new ArrayList<>();
        for (int tmp : nums) {
            list.add(tmp);
        }
        Collections.sort(list);
        int[] answer = new int[nums.length/2];

        for (int i=0; i<nums.length/2; i++) {
            answer[i] = list.get(i);
            list.remove(new Integer(answer[i]*2));
        }

        return answer;
    }

    public static void main(String[] args){
        P02_수열찾기 T = new P02_수열찾기();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
