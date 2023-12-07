package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P02_아나그램_해쉬 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();
        HashMap<Character, Integer> amap = new HashMap<>();
        HashMap<Character, Integer> bmap = new HashMap<>();

        for (int i=0; i<a.length; i++) {
            amap.put(a[i], amap.getOrDefault(a[i], 0) + 1);
            bmap.put(b[i], bmap.getOrDefault(b[i], 0) + 1);
        }

        String answer = "YES";
        for (char tmp : amap.keySet()) {
            if (amap.get(tmp)!=bmap.get(tmp)) {
                answer = "NO";
                break;
            }
        }

        System.out.println(answer);
    }
}
