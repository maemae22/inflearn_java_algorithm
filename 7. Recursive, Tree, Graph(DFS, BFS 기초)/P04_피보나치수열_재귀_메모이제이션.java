import java.util.*;
import java.io.*;

// 1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
// 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
// ex. 10 -> 1 1 2 3 5 8 13 21 34 55
public class P04_피보나치수열_재귀_메모이제이션 {

    // 방법0. 배열 사용
    public static void main0(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 피보나치 수열 만들기
        int[] answer = new int[N+1];
        answer[1] = 1;
        answer[2] = 2;
        for (int i=3; i<=N; i++) {
            answer[i] = answer[i-2] + answer[i-1];
        }

        // 출력
        for (int i=1; i<=N; i++) {
            System.out.print(answer[i] + " ");
        }
    }


    // 방법1. for문으로 출력 (재귀함수)
    public static void main1(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // Pibo1 함수를 N번 호출.. 매우 느림
        for (int i=1; i<=N; i++) {
            System.out.print(Pibo1(i)+" ");
        }
    }

    // 피보나치 수열의 N번째 항 1개만 return. (숫자 하나)
    public static int Pibo1(int N) {
        if (N==1 || N==2) {
            return 1;
        } else {
            return Pibo1(N-2) + Pibo1(N-1);
        }
    }

}
