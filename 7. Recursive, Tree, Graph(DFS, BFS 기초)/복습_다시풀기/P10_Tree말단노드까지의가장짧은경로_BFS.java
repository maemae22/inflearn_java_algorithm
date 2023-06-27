package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P10_Tree말단노드까지의가장짧은경로_BFS {

    public static void main(String[] args) throws Exception {
        Nodd root = new Nodd(1);
        root.lt = new Nodd(2);
        root.lt.lt = new Nodd(4);
        root.lt.rt = new Nodd(5);
        root.rt = new Nodd(3);

        System.out.println(BFS(root));
    }

    public static int BFS(Nodd root) {
        Queue<Nodd> q = new LinkedList<>();
        q.offer(root);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                Nodd tmp = q.poll();
                if (tmp.lt==null && tmp.rt==null) {
                    return level;
                }
                if (tmp.lt != null) {
                    q.offer(tmp.lt);
                }
                if (tmp.rt != null) {
                    q.offer(tmp.rt);
                }
            }
            level++;
        }
        return -7;
    }
}
