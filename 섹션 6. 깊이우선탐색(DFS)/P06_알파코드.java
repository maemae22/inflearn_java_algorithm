import java.util.*;

public class P06_알파코드 {

    static String letter;
    static int answer;

    public int solution(String s) {
        letter = s;
        answer = 0;

        DFS(0);
        return answer;
    }

    public void DFS(int index) {
        if (index==letter.length()) {
            answer++;
        } else {
            if (letter.charAt(index)!='0') {
                for (int i=1; i<=2; i++) {
                    if (index+i<=letter.length()) {
                        int num = Integer.parseInt(letter.substring(index, index+i));
                        if (1<=num && num<=26) {
                            DFS(index+i);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        P06_알파코드 T = new P06_알파코드();
        System.out.println(T.solution("25114"));
        System.out.println(T.solution("23251232"));
        System.out.println(T.solution("21020132"));
        System.out.println(T.solution("21350"));
        System.out.println(T.solution("120225"));
        System.out.println(T.solution("232012521"));
    }
}
