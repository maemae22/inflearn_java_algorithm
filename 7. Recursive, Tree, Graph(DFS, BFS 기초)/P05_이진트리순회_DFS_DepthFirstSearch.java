import java.util.*;
import java.io.*;

// 아래 그림과 같은 이진트리를 전위순회와 후위순회를 연습해보세요.      1
// 전위순회 출력 : 1 2 4 5 3 6 7                            2   |   3
// 중위순회 출력 : 4 2 5 1 6 3 7                          4 | 5     6 | 7
// 후위순회 출력 : 4 5 2 6 7 3 1
public class P05_이진트리순회_DFS_DepthFirstSearch {

    Node root;

    public static void main(String[] args) throws Exception {

        P05_이진트리순회_DFS_DepthFirstSearch tree = new P05_이진트리순회_DFS_DepthFirstSearch();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        tree.DFS(tree.root);
    }

    public void DFS (Node root) {
        if (root == null) {
            return;
        } else {
//            System.out.print(root.data + " "); // 전위순회 출력 : 1 2 4 5 3 6 7

            DFS(root.lt);

            System.out.print(root.data + " "); // 중위순회 출력 : 4 2 5 1 6 3 7

            DFS(root.rt);

//            System.out.print(root.data + " "); // 후위순회 출력 : 4 5 2 6 7 3 1
        }
    }
}

class Node {
    int data;
    Node lt;
    Node rt;

    public Node(int data) {
        this.data = data;
        lt = null;
        rt = null;
    }
}
