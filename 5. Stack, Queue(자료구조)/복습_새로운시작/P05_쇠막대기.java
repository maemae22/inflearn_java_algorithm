package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P05_쇠막대기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<arr.length; i++) {
            if (arr[i]=='(' && arr[i+1]==')') { // 레이저일 때
                answer += stack.size();
                i++;
            } else if (arr[i]=='(') { // 쇠막대기의 시작
                stack.push(arr[i]);
            } else { // 쇠막대기의 끝
                answer++;
                stack.pop();
            }
        }

        System.out.println(answer);
    }
}
