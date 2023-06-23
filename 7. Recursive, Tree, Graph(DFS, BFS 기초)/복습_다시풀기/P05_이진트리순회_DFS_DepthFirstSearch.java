package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P05_이진트리순회_DFS_DepthFirstSearch {

    public static void main(String[] args) throws Exception {

        Node root = new Node(1);
        root.lt = new Node(2);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt = new Node(3);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        before(root); // 전위순회 출력
        System.out.println();
        mid(root); // 중위순회 출력
        System.out.println();
        after(root); // 후위순회 출력
    }

    public static void before(Node node) {
        if (node == null) {
            return;
        } else {
            System.out.print(node.num+" ");
            before(node.lt);
            before(node.rt);
        }
    }

    public static void mid(Node node) {
        if (node == null) {
            return;
        } else {
            mid(node.lt);
            System.out.print(node.num+" ");
            mid(node.rt);
        }
    }

    public static void after(Node node) {
        if (node == null) {
            return;
        } else {
            after(node.lt);
            after(node.rt);
            System.out.print(node.num+" ");
        }
    }
}

class Node {
    int num;
    Node lt;
    Node rt;

    Node(int num) {
        this.num = num;
        lt = null;
        rt = null;
    }
}
