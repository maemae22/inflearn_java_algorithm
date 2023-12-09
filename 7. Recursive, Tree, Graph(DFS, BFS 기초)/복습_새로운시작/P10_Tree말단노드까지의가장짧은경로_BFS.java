package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P10_Tree말단노드까지의가장짧은경로_BFS {

    public static void main(String[] args) throws Exception {
        Ode root = new Ode(1);
        root.lt = new Ode(2);
        root.rt = new Ode(3);
        root.lt.lt = new Ode(4);
        root.lt.rt = new Ode(5);

        System.out.println(BFS(root));
    }

    public static int BFS(Ode root) {
        Queue<Ode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                Ode tmp = q.poll();
                if (tmp.lt==null && tmp.rt==null) {
                    return level;
                }
                if (tmp.lt!=null) {
                    q.offer(tmp.lt);
                }
                if (tmp.rt!=null) {
                    q.offer(tmp.rt);
                }
            }
            level++;
        }

        return -1;
    }
}

class Ode {
    int num;
    Ode lt;
    Ode rt;
    Ode(int num) {
        this.num = num;
        lt = null;
        rt = null;
    }
}
