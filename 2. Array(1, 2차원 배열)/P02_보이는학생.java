import java.util.*;
import java.io.*;

/*
선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는
선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
ex.
8
130 135 148 140 145 150 150 153
-> 5
 */
public class P02_보이는학생 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] height = new int[N];
        for (int i=0; i<N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        int max = height[0];
        int count = 1;

        for (int i=1; i<N; i++) {
            if (height[i] > max) {
                count++;
                max = height[i];
            }
        }

        System.out.println(count);
    }
}
