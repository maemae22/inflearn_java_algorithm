import java.util.*;
import java.io.*;

/*
학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.
선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.
반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.
ex.
15
BACBACCACCBDEDE
-> C
 */
public class P01_학급회장_해쉬 {

    // 방법1. 그냥 배열 이용
    public static void main1(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String letter = br.readLine();

        int[] result = new int[5];

        for (int i=0; i<letter.length(); i++) {
            char vote = letter.charAt(i);

            if (vote == 'A') {
                result[0]++;
            } else if (vote == 'B') {
                result[1]++;
            } else if (vote == 'C') {
                result[2]++;
            } else if (vote == 'D') {
                result[3]++;
            } else {
                result[4]++;
            }
        }

        int max = 0;
        int index = 0;

        for (int i=0; i<5; i++) {
            if (max < result[i]) {
                max = result[i];
                index = i;
            }
        }

        if (index == 0) {
            System.out.println("A");
        } else if (index == 1) {
            System.out.println("B");
        } else if (index == 2) {
            System.out.println("C");
        } else if (index == 3) {
            System.out.println("D");
        } else {
            System.out.println("E");
        }
    }

    // 방법2. HashMap 이용 (추천 !)
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String letter = br.readLine();

        char answer = ' ';
        HashMap<Character, Integer> result = new HashMap<>();

        for (char vote : letter.toCharArray()) {
            result.put(vote, result.getOrDefault(vote, 0)+1 );
        }

        int max = 0;
        for (char key : result.keySet()) {
            if (result.get(key) > max) {
                max = result.get(key);
                answer = key;
            }
        }

        System.out.println(answer);

        /*
        // cf. 그 외 HashMap의 유용한 메서드
        System.out.println('A' + " " + result.get('A')); // A 3

        System.out.println(result.containsKey('B')); // containsKey() : boolean형 (true / false 로 리턴) - true
        System.out.println(result.containsKey('G')); // false

        System.out.println(result.size()); // 5

        System.out.println(result.remove('D')); // 삭제 후, D의 Value 값을 return. (2)
        System.out.println(result.remove('H')); // null (해당하는 key가 없는 경우 null을 반환함)
        System.out.println(result.size()); // 4
         */

    }
}
