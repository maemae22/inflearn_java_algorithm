import java.util.*;
import java.io.*;

// 10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하세요. 단 재귀함수를 이용해서 출력해야 합니다.
// ex. 11 -> 1011
public class P02_이진수출력_재귀_재귀함수를이용한이진수출력 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Binary(N);
        System.out.println();
        binary(N);
    }

    public static void Binary(int N) {
        if (N/2 == 0) {
            System.out.print("1");
            return;
        } else {
            Binary(N/2);
            System.out.print(N%2);
        }
    }

    public static void binary(int N) {
        if (N == 0) {
            return;
        } else {
            binary(N/2);
            System.out.print(N%2);
        }
    }
}
