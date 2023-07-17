import java.util.*;

public class P06_과일가져가기 {

    // 문제 분석 : 서로 교환했을 때 이득이 나는 조건
    // 조건1. 각 학생의 최솟값이 유니크(유일)해야 한다.
    // 조건2. 서로 교환하려고 하는 두 학생의 최솟값인 과일이 서로 달라야 한다.
    // 조건3. 교환했을 때 1개 증가한 과일의 개수가 그대로 최솟값을 유지해야 한다.
    // 조건4. 각 학생은 1번만 교환할 수 있다.
    public int solution(int[][] fruit) {
        int N = fruit.length;
        int answer = 0;

        // 조건에 맞지 않아 교환이 불가능하거나 이미 교환했을 경우 -1, 교환이 가능한 상태라면 fruit이 최소값인 index를 저장
        int[] check = new int[N];

        for (int i=0; i<N; i++) {
            int[] arr = new int[3];
            for (int j=0; j<3; j++) {
                arr[j] = fruit[i][j];
            }
            Arrays.sort(arr);

            if (arr[0]!=arr[1]) { // 조건1 확인
                for (int j=0; j<3; j++) {
                    if (arr[0]==fruit[i][j]) {
                        check[i] = j;
                        break;
                    }
                }
            } else {
                check[i] = -1;
            }
            answer += arr[0];
        }

        for (int i=0; i<N; i++) {
            if (check[i]!=-1) { // 조건4 확인
                for (int j=i+1; j<N; j++) {
                    if (check[j]!=-1 && check[i]!=check[j] // 조건4 확인 & 조건2 확인
                            && fruit[i][check[j]]>0 && fruit[j][check[i]]>0 // 교환해줄 수 있는지 확인
                            && fruit[i][check[i]]+1<=fruit[i][check[j]]-1 && fruit[j][check[j]]+1<=fruit[j][check[i]]-1) { // 조건3 확인
                        check[i] = -1;
                        check[j] = -1;
                        answer += 2;
//                        System.out.print(i+"와 "+j+"를 교환함 / ");
                        break;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P06_과일가져가기 T = new P06_과일가져가기();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}
