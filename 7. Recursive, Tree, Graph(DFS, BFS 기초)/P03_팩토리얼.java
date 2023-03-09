import java.util.*;
import java.io.*;

// 자연수 N이 입력되면 N!를 구하는 프로그램을 작성하세요.
// ex. 5 -> 120 ( 설명 : 5! = 5*4*3*2*1=120 )
public class P03_팩토리얼 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(Fact(N));
    }

    public static int Fact(int N) {
        if (N==1) {
            return 1;
        } else {
            return N * Fact(N-1);
        }
    }
}
