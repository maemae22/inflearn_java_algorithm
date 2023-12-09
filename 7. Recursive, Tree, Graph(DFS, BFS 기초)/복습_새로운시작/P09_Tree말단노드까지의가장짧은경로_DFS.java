package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P09_Tree말단노드까지의가장짧은경로_DFS {

    static Mode root;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        root = new Mode(1);
        root.lt = new Mode(2);
        root.rt = new Mode(3);
        root.lt.lt = new Mode(4);
        root.lt.rt = new Mode(5);

        DFS(root, 0);
        System.out.println(answer);
    }

    public static void DFS(Mode root, int level) {
        if (root.lt!=null) {
            DFS(root.lt, level+1);
        }
        if (root.rt!=null) {
            DFS(root.rt, level+1);
        }
        if (root.lt==null && root.rt==null) {
            answer = Math.min(answer, level);
        }
    }
}

class Mode {
    int num;
    Mode lt;
    Mode rt;
    Mode(int num) {
        this.num = num;
        lt = null;
        rt = null;
    }
}
