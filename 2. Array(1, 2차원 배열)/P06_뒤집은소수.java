import java.util.*;
import java.io.*;

/*
N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
첫 자리부터의 연속된 0은 무시한다.
ex.
9
32 55 62 20 250 370 200 30 100
-> 23 2 73 2 3
 */
public class P06_뒤집은소수 {

    // 방법1. StringBuilder + Integer.parseInt() 를 사용하여 숫자를 뒤집음.
    public static void main1(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<N; i++) {
            // String "0000486" -> int 486로 바꾸려면, Integer.parseInt("0000486") 하면 된다. -> 486으로 바뀌어서 반환됨 !
            arr[i] = Integer.parseInt(sb.append(st.nextToken()).reverse().toString()); // arr은 뒤집은 수들의 배열
            sb.setLength(0); // StringBuilder 초기화
        }

        for (int i=0; i<N; i++) {
            if (isSosu(arr[i])) {
                sb.append(arr[i]);
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
    }

    // 방법2. 나누기, 나머지 연산을 활용한 숫자 뒤집기.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int oneNum = 0;
        int reverse = 0;
        for (int i=0; i<N; i++) {

            // 나누기, 나머지 연산을 활용한 숫자 뒤집기.
            oneNum = Integer.parseInt(st.nextToken());
            while (oneNum > 0) {
                reverse = reverse*10 + oneNum%10;
                oneNum = oneNum/10;
            }

            if (isSosu(reverse)) {
                sb.append(reverse);
                sb.append(" ");
            }
            reverse = 0;
        }

        System.out.println(sb.toString());
    }

    // num이 소수인지 아닌지 판별함
    public static boolean isSosu(int num) {

        if (num == 1) {
            return false;
        }

        for (int i=2; i<num; i++) {
            if (num%i == 0) {
                return false;
            }
        }

        return true;
    }
}
