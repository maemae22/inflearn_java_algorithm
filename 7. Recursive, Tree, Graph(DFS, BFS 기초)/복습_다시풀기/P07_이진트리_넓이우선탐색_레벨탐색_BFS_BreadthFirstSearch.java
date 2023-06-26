package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P07_이진트리_넓이우선탐색_레벨탐색_BFS_BreadthFirstSearch {

    public static void main(String[] args) throws Exception {

        Nod root = new Nod(1);
        root.lt = new Nod(2);
        root.lt.lt = new Nod(4);
        root.lt.rt = new Nod(5);
        root.rt = new Nod(3);
        root.rt.lt = new Nod(6);
        root.rt.rt = new Nod(7);

        BFS(root);
    }

    public static void BFS(Nod root) {
        Queue<Nod> q = new LinkedList<>();

        q.offer(root); // 초기 : 0레벨 넣어줌
        int level = 0;

        while (!q.isEmpty()) {
            System.out.println("현재 레벨은 : "+level);

            int size = q.size();
            for (int i=0; i<size; i++) {
                Nod tmp = q.poll();
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

class Nod {
    int num;
    Nod lt;
    Nod rt;

    Nod(int num) {
        this.num = num;
        lt = null;
        rt = null;
    }
}
