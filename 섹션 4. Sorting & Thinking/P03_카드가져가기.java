import java.util.*;

public class P03_카드가져가기 {
    public int solution(int[] nums, int k) {
        int[] arr = nums.clone();
        Arrays.sort(arr);

        int round = nums.length/2;
        List<Minus> list = new ArrayList<>();
        for (int i=0; i<round; i++) {
            list.add(new Minus(i, arr[i*2+1] - arr[i*2]));
        }
        Collections.sort(list);

        List<Integer> pick = new ArrayList<>();
        for (int i=0; i<k; i++) {
            pick.add(list.get(i).index);
        }

        int answer = 0;
        for (int i=0; i<round; i++) {
            if (pick.contains(i)) {
                answer += arr[2*i+1];
            } else {
                answer += arr[2*i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P03_카드가져가기 T = new P03_카드가져가기();
        System.out.println(T.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
        System.out.println(T.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
        System.out.println(T.solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
        System.out.println(T.solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
        System.out.println(T.solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
    }
}

class Minus implements Comparable<Minus> {
    int index;
    int value;
    Minus(int index, int value) {
        this.index = index;
        this.value = value;
    }
    @Override
    public int compareTo(Minus o) {
        return o.value - this.value;
    }
}
