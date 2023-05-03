import java.util.*;
import java.io.*;

// 1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
// 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
// ex. 10 -> 1 1 2 3 5 8 13 21 34 55
public class P04_피보나치수열_재귀_메모이제이션 {

    // 방법0. 배열 사용
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 피보나치 수열 만들기
        int[] answer = new int[N+1];
        answer[1] = 1;
        answer[2] = 1;
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


    // 방법2. ⭐ static 변수 활용
    static int[] arr2;

    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr2 = new int[N+1];

        // 함수 1번만 호출 !
        Pibo2(N);

        for (int i=1; i<=N; i++) {
            System.out.print(arr2[i] + " ");
        }
    }

    public static int Pibo2(int N) {
        if (N==1 || N==2) {
            return arr2[N] = 1; // ⭐
        } else {
            return arr2[N] = Pibo2(N-2) + Pibo2(N-1); // ⭐
        }
    }


    // 방법3. ⭐⭐ 메모이제이션 활용 ⭐⭐ ( + static 변수 활용 )
    // 메모이제이션(memoization) : 컴퓨터 프로그램이 동일한 계산을 반복해야 할 때, 이전에 계산한 값을 메모리에 저장함으로써
    //                          동일한 계산의 반복 수행을 제거하여 프로그램 실행 속도를 빠르게 하는 기술이다.
    //                          동적 계획법의 핵심이 되는 기술이다.
    static int[] arr3;

    public static void main3(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr3 = new int[N+1];

        // 함수 1번만 호출하는 것은 동일하나, 이미 구했던 값은 저장해놓고 다시 구하지 않는다는 점에서 시간이 확 단축됨 !! 제일 좋다 ~!!
        Pibo3(N);

        for (int i=1; i<=N; i++) {
            System.out.print(arr3[i] + " ");
        }
    }

    public static int Pibo3(int N) {
        if (arr3[N] != 0) {
            return arr3[N];
        }

        if (N==1 || N==2) {
            return arr3[N] = 1;
        } else {
            return arr3[N] = Pibo3(N-2) + Pibo3(N-1);
        }
    }

}
