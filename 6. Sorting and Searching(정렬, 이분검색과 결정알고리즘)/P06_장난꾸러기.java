import java.util.*;
import java.io.*;

/*
철수네 반에는 N명의 학생들이 있습니다.
선생님은 반 학생들에게 반 번호를 정해 주기 위해 운동장에 반 학생들을 키가 가장 작은 학생부터 일렬로 키순으로 세웠습니다.
제일 앞에 가장 작은 학생부터 반 번호를 1번부터 N번까지 부여합니다. 철수는 짝꿍보다 키가 큽니다.
그런데 철수가 앞 번호를 받고 싶어 짝꿍과 자리를 바꿨습니다.
선생님은 이 사실을 모르고 학생들에게 서있는 순서대로 번호를 부여했습니다.
철수와 짝꿍이 자리를 바꾼 반 학생들의 일렬로 서있는 키 정보가 주어질 때 철수가 받은 번호와 철수 짝꿍이 받은 번호를
차례로 출력하는 프로그램을 작성하세요.
ex.
9
120 125 152 130 135 135 143 127 160
-> 3 8 ( 출력해설 : 키 정보 152가 철수이고, 127이 철수 짝꿍입니다. )
 */
public class P06_장난꾸러기 {

    public static void main(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 로직
        // 배열 복사하기 !
        // 방법1-1. for문 돌면서 배열 복사
        int[] copy = new int[arr.length];
        for (int i=0; i<arr.length; i++) {
            copy[i] = arr[i];
        }

        // 방법1-2. arr.clone(); 사용
//        int[] copy = arr.clone();

        Arrays.sort(copy);

        // arr 배열과 copy 배열에서 다른 index 2개 찾기
        int first = -1;
        int second = -1;
        for (int i=0; i<N; i++) {
            if (first == -1 && copy[i]!=arr[i]) {
                first = i+1;
            } else if (first !=-1 && copy[i]!=arr[i]) {
                second = i+1;
            } else if (first!=-1 && second !=-1) {
                break;
            }
        }

        System.out.println(first+" "+second);
    }

    public static void main2(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 로직
        // 배열 복사하기 !
        int[] copy = arr.clone();

        Arrays.sort(copy);

        // arr 배열과 copy 배열에서 다른 index 2개 찾기 : ArrayList 사용
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i=0; i<N; i++) {
            if (arr[i] != copy[i]) {
                answer.add(i+1);
            }
        }

        System.out.println(answer.get(0)+" "+answer.get(1));
    }
}
