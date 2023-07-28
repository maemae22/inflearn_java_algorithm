import java.util.*;

public class P01_가장가까운큰수 {

    static int answer;
    static int N;
    static int[] num;

    public int solution(int n) {
        N = n;
        answer = Integer.MAX_VALUE;
        String stringNum = String.valueOf(n);
        num = new int[stringNum.length()];
        int tmp = n;
        for (int i=num.length-1; i>=0; i--) {
            num[i] = tmp%10;
            tmp /= 10;
        }
//        System.out.println(arrayToInt(num));

        DFS(0, new int[num.length], new int[num.length]);
        return answer==Integer.MAX_VALUE ? -1 : answer;
    }

    public void DFS(int count, int[] arr, int[] check) {
        if (count==1 && arr[0]<num[0]) {
            return;
        }

        if (count==num.length) {
            int num = arrayToInt(arr);
            if (num>N) {
                answer = Math.min(answer, num);
            }
        } else {
            for (int i=0; i<arr.length; i++) {
                if (check[i]==0) {
                    arr[count] = num[i];
                    check[i] = 1;
                    DFS(count+1, arr, check);
                    check[i] = 0;
                }
            }
        }
    }

    public int arrayToInt(int[] arr) {
        int sum = 0;
        for (int i=0; i<arr.length; i++) {
            sum += arr[i]*Math.pow(10, arr.length-i-1);
        }
        return sum;
    }

    public static void main(String[] args) {
        P01_가장가까운큰수 T = new P01_가장가까운큰수();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}
