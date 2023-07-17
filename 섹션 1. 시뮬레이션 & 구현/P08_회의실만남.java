import java.util.*;

public class P08_회의실만남 {
    public int[] solution(int[] enter, int[] exit){
        int N = enter.length;
        int[] answer = new int[N];
        int[] income = new int[N]; // income[i] = i번째 사람이 들어온 순서
        int[] enterT = new int[N]; // enterT[i] = i번째 사람이 들어온 시각
        int[] outT = new int[N]; // outT[i] = i번째 사람이 나간 시각

        for (int i=0; i<enter.length; i++) {
            income[enter[i]-1] = i;
        }

        int time = 0;
        int incomeIndex = 0;
        for (int out : exit) {
            int outPerson = out-1;
            while (incomeIndex<=income[outPerson]) {
                int incomePerson = enter[incomeIndex++] -1;
                enterT[incomePerson] = time++;
            }
            outT[outPerson] = time++;
        }

//        System.out.println("income = "+Arrays.toString(income));
//        System.out.println("enterT = "+Arrays.toString(enterT));
//        System.out.println("outT = "+Arrays.toString(outT));

        for (int i=0; i<N; i++) {
            for (int j=i+1; j<N; j++) {
                if (!(outT[j]<enterT[i] || outT[i]<enterT[j])) {
                    answer[i]++;
                    answer[j]++;
//                    System.out.println(i+"와 "+j+"가 만남");
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        P08_회의실만남 T = new P08_회의실만남();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}
