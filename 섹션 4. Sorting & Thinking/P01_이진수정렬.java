import java.util.*;

public class P01_이진수정렬 {
    public int[] solution(int[] nums){
        List<Num> list = new ArrayList<>();
        for (int tmp : nums) {
            int count = 0;
            int num = tmp;
            while (num>0) {
                if (num%2==1) {
                    count++;
                }
                num/=2;
            }
            list.add(new Num(tmp, count));
        }

        Collections.sort(list);

        int[] answer = new int[nums.length];
        for (int i=0; i<answer.length; i++) {
            answer[i] = list.get(i).ten;
        }

        return answer;
    }

    public static void main(String[] args){
        P01_이진수정렬 T = new P01_이진수정렬();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}

class Num implements Comparable<Num> {
    int ten;
    int two;
    Num(int ten, int two) {
        this.ten = ten;
        this.two = two;
    }
    @Override
    public int compareTo(Num o) {
        return this.two!=o.two ? this.two-o.two : this.ten-o.ten;
    }
}
