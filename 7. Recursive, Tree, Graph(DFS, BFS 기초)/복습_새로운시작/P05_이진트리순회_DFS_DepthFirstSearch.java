package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P05_이진트리순회_DFS_DepthFirstSearch {

    public static void main(String[] args) throws Exception {
        One root = new One(1);
        root.lt = new One(2);
        root.rt = new One(3);
        root.lt.lt = new One(4);
        root.lt.rt = new One(5);
        root.rt.lt = new One(6);
        root.rt.rt = new One(7);

        System.out.println("전위순회 출력");
        DFS1(root);
        System.out.println();

        System.out.println("중위순회 출력");
        DFS2(root);
        System.out.println();

        System.out.println("후위순회 출력");
        DFS3(root);
        System.out.println();
    }

    public static void DFS1(One root) { // 전위순회
        if (root == null) {
            return;
        }
        System.out.print(root.num+" ");
        DFS1(root.lt);
        DFS1(root.rt);
    }

    public static void DFS2(One root) { // 중위순회
        if (root == null) {
            return;
        }
        DFS2(root.lt);
        System.out.print(root.num+" ");
        DFS2(root.rt);
    }

    public static void DFS3(One root) { // 후위순회
        if (root == null) {
            return;
        }
        DFS3(root.lt);
        DFS3(root.rt);
        System.out.print(root.num+" ");
    }
}

class One {
    int num;
    One lt;
    One rt;
    One(int num) {
        this.num = num;
        this.lt = null;
        this.rt = null;
    }
}
