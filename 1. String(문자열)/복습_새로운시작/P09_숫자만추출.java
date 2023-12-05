package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P09_숫자만추출 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine().replaceAll("[^0-9]", "");
        System.out.println(Integer.parseInt(num));
    }
}
