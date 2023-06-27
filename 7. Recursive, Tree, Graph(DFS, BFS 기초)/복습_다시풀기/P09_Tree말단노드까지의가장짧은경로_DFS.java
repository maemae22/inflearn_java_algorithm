package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P09_Tree말단노드까지의가장짧은경로_DFS {

    static int answer;

    public static void main(String[] args) throws Exception {
        Nodd root = new Nodd(1);
        root.lt = new Nodd(2);
        root.lt.lt = new Nodd(4);
        root.lt.rt = new Nodd(5);
        root.rt = new Nodd(3);

        answer = Integer.MAX_VALUE;
        DFS(root, 0);
        System.out.println(answer);
    }

    public static void DFS(Nodd node, int level) {
        if (node.lt==null && node.rt==null) {
            answer = Math.min(answer, level);
        }
        if (node.lt != null) {
            DFS(node.lt, level+1);
        }
        if (node.rt != null) {
            DFS(node.rt, level+1);
        }
    }
}

class Nodd {
    int num;
    Nodd lt;
    Nodd rt;

    Nodd(int num) {
        this.num = num;
        lt = null;
        rt = null;
    }
}
