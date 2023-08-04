import java.util.*;

public class P05_IP주소 {

    static List<String> answers;
    static String letter;

    public String[] solution(String s) {
        answers = new ArrayList<>();
        letter = s;

        DFS(0, new ArrayList<Integer>());

        if (answers.size()==0) {
            return new String[]{};
        } else {
            String[] answer = new String[answers.size()];
            for (int i=0; i<answers.size(); i++) {
                answer[i] = answers.get(i);
            }
            return answer;
        }
    }

    public void DFS(int index, ArrayList<Integer> output) {
        if (output.size()>4 || (output.size()==4 && index!=letter.length())) {
            return;
        }

        if (output.size()==4 && index==letter.length()) {
            StringBuilder sb = new StringBuilder();
            sb.append(output.get(0));
            for (int i=1; i<=3; i++) {
                sb.append(".").append(output.get(i));
            }
            answers.add(sb.toString());
        } else {
            if (letter.charAt(index)=='0') {
                output.add(0);
                DFS(index+1, output);
                output.remove(output.size()-1);
            } else {
                for (int i=1; i<=3; i++) {
                    if (index+i<=letter.length()) {
                        int num = Integer.parseInt(letter.substring(index, index+i));
                        if (num<=255) {
                            output.add(num);
                            DFS(index+i, output);
                            output.remove(output.size()-1);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        P05_IP주소 T = new P05_IP주소();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }
}
