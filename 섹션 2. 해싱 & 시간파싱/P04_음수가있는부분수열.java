import java.util.*;

public class P04_음수가있는부분수열 {
    public int solution(int[] nums, int M) {

        // 키 : sum(배열의 0~i번째까지의 합) | 값 : 그 sum의 개수(빈도수)
        HashMap<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        int sum = 0; // 배열의 0~i번째까지의 합

        map.put(0, 1); // sum==M일 경우 카운트를 증가시키기 위해 미리 초기값으로 (0, 1)을 map에 넣어줌 !
        for (int tmp : nums) {
            sum += tmp;
            if (map.containsKey(sum-M)) {
                answer += map.get(sum-M);
//                System.out.println(map+" / "+map.get(sum-M));
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return answer;
    }

    public static void main(String[] args){
        P04_음수가있는부분수열 T = new P04_음수가있는부분수열();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}
