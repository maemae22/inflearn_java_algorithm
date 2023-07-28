import java.util.*;

public class P01_가장가까운큰수 {

    static int answer;
    static int N;
    static int[] num;

    public int arrayToInt(int[] arr) {
        int sum = 0;
        for (int i=0; i<arr.length; i++) {
            sum += arr[i]*Math.pow(10, arr.length-i-1);
        }
        return sum;
    }

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

    public int solution2(int n) {
        N = n;
        answer = Integer.MAX_VALUE;
        String stringNum = String.valueOf(n);
        num = new int[stringNum.length()];
        find = false;

        int tmp = n;
        for (int i=num.length-1; i>=0; i--) {
            num[i] = tmp%10;
            tmp /= 10;
        }

        Arrays.sort(num);

        DFS2(0, new int[num.length], new int[num.length]);
        return answer==Integer.MAX_VALUE ? -1 : answer;
    }

    static int front = Integer.parseInt(String.valueOf(String.valueOf(N).charAt(0)));
    static boolean find;
    public void DFS2(int count, int[] arr, int[] check) {
        if (find || count==1 && arr[0]<front) {
            return;
        }

        if (count==num.length) {
            int num = arrayToInt(arr);
            if (num>N) {
                answer = num;
                find = true;
            }
        } else {
            for (int i=0; i<arr.length; i++) {
                if (check[i]==0) {
                    arr[count] = num[i];
                    check[i] = 1;
                    DFS2(count+1, arr, check);
                    check[i] = 0;
                }
            }
        }
    }

    public int solution3(int n) {
        N = n;
        answer = -1;
        String stringNum = String.valueOf(n);
        num = new int[stringNum.length()];
        find = false;

        int tmp = n;
        for (int i=num.length-1; i>=0; i--) {
            num[i] = tmp%10;
            tmp /= 10;
        }

        Arrays.sort(num);

        DFS3(0, 0, new int[num.length]);
        return answer;
    }

    public void DFS3(int count, int now, int[] check) {
        if (find) {
            return;
        }

        if (count==num.length) {
            if (now>N) {
                answer = now;
                find = true;
            }
        } else {
            for (int i=0; i<check.length; i++) {
                if (check[i]==0) {
                    check[i] = 1;
                    DFS3(count+1, now*10+num[i], check);
                    check[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        P01_가장가까운큰수 T = new P01_가장가까운큰수();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
        System.out.println();
        System.out.println(T.solution2(123));
        System.out.println(T.solution2(321));
        System.out.println(T.solution2(20573));
        System.out.println(T.solution2(27711));
        System.out.println(T.solution2(54312));
        System.out.println();
        System.out.println(T.solution3(123));
        System.out.println(T.solution3(321));
        System.out.println(T.solution3(20573));
        System.out.println(T.solution3(27711));
        System.out.println(T.solution3(54312));
    }
}
