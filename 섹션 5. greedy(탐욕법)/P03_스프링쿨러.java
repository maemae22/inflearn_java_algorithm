import java.util.*;

public class P03_스프링쿨러 {
    public int solution(int n, int[] nums) {
        List<Spring> list = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (nums[i]!=0) {
                list.add(new Spring(i-nums[i], i+nums[i]));
            }
        }

        Collections.sort(list);
        int answer = 0;
        int index = 0;
        int end = 0;
        while (index<list.size() && end<n) {
            if (end<list.get(index).start) {
                return -1;
            } else {
                int tmpEnd = end;
                while (index<list.size() && list.get(index).start<=end) {
                    tmpEnd = Math.max(tmpEnd, list.get(index).end);
                    index++;
                }
                if (end!=tmpEnd) {
                    answer++;
                }
                end = tmpEnd;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P03_스프링쿨러 T = new P03_스프링쿨러();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}

class Spring implements Comparable<Spring> {
    int start;
    int end;
    Spring(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Spring o) {
        return this.start!=o.start ? this.start-o.start : o.end-this.end;
    }
}
