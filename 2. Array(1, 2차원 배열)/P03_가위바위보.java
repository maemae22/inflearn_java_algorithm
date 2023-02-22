import java.util.*;
import java.io.*;

/*
A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
 */
public class P03_가위바위보 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<N; i++) {
            System.out.println(game(A[i], B[i]));
        }
    }

    // 1:가위, 2:바위, 3:보
    public static String game(int A, int B) {

        if (A==B) {
            return "D";
        } else if ( (A==1 && B==3) || (A==2 && B==1) || (A==3 && B==2) ) {
            return "A";
        } else {
            return "B";
        }
    }

}
