import java.util.*;
import java.io.*;

/*
Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로
알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.
ex1.
AbaAeCe
baeeACA
-> YES
ex2.
abaCC
Caaab
-> NO
 */
public class P02_아나그램_해쉬 {

    // 방법1. HashMap을 2개 만들어 비교
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();

        HashMap<Character, Integer> firstMap = letterToHashMap(first);
        HashMap<Character, Integer> secondMap = letterToHashMap(second);

        boolean ok = true;
        for (char key : firstMap.keySet()) {
            if (firstMap.get(key) != secondMap.get(key)) {
                System.out.println("NO");
                ok = false;
                break;
            }
        }

        if (ok) {
            System.out.println("YES");
        }
    }

    public static HashMap letterToHashMap(String letter) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : letter.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1 );
        }
        return map;
    }

    // 방법2. HashMap 하나로 비교
    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : first.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1 );
        }

        String answer = "YES";
        for (char c : second.toCharArray()) {
            if ( !map.containsKey(c) || map.get(c)==0 ) {
                answer = "NO";
                break;
            } else {
                map.put(c, map.get(c)-1 );
            }
        }

        System.out.println(answer);
    }
}
