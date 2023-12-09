package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P07_이진트리_넓이우선탐색_레벨탐색_BFS_BreadthFirstSearch {

    public static void main(String[] args) throws Exception {
        Tree root = new Tree(1);
        root.lt = new Tree(2);
        root.rt = new Tree(3);
        root.lt.lt = new Tree(4);
        root.lt.rt = new Tree(5);
        root.rt.lt = new Tree(6);
        root.rt.rt = new Tree(7);

        BFS(root);
    }

    public static void BFS(Tree root) {
        Queue<Tree> q = new LinkedList<>();
        q.offer(root);
        int level = 1;

        while (!q.isEmpty()) {
            System.out.print(level+"레벨 : ");
            int size = q.size();
            for (int i=0; i<size; i++) {
                Tree tmp = q.poll();
                System.out.print(tmp.num+" ");
                if (tmp.lt != null) {
                    q.offer(tmp.lt);
                }
                if (tmp.rt != null) {
                    q.offer(tmp.rt);
                }
            }
            level++;
            System.out.println();
        }
    }
}

class Tree {
    int num;
    Tree lt;
    Tree rt;
    Tree(int num) {
        this.num = num;
        lt = null;
        rt = null;
    }
}
