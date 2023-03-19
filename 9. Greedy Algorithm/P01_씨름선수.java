import java.util.*;
import java.io.*;

/*
현수는 씨름 감독입니다. 현수는 씨름 선수를 선발공고를 냈고, N명의 지원자가 지원을 했습니다.
현수는 각 지원자의 키와 몸무게 정보를 알고 있습니다.
현수는 씨름 선수 선발 원칙을 다음과 같이 정했습니다.
“A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은(크고, 무겁다) 지원자가 존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.”
N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지 알아내는 프로그램을 작성하세요.
ex.
5
172 67
183 65
180 70
170 72
181 60
->
3 ( 출력설명 : (183, 65), (180, 70), (170, 72) 가 선발됩니다. (181, 60)은 (183, 65)보다 키와 몸무게 모두 낮기 때문에 탈락이고, (172, 67)은 (180, 70) 때문에 탈락입니다. )
 */
public class P01_씨름선수 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] keys = new int[N];
        int[] moms = new int[N];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            keys[i] = Integer.parseInt(st.nextToken());
            moms[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i=0; i<N; i++) {
            boolean pick = true;
            for (int j=0; j<N; j++) {
                if (j!=i && keys[j]>keys[i] && moms[j]>moms[i]) {
                    pick = false;
                }
            }
            if (pick) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
