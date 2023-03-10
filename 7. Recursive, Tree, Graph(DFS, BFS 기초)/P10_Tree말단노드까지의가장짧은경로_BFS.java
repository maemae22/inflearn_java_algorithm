import java.util.*;
import java.io.*;

// 이진트리에서 루트 노드 1에서 말단노드까지의 길이 중 가장 짧은 길이를 구하는 프로그램을 작성하세요.
// 각 경로의 길이는 루트노드에서 말단노드까지 가는데 이동하는 횟수를, 즉 간선(에지)의 개수를 길이로 하겠습니다.
// ex. 가장 짧은 길이는 3번 노드까지의 길이인 1이다.
public class P10_Tree말단노드까지의가장짧은경로_BFS {

    public static void main(String[] args) throws Exception {
        Nodee root = new Nodee(1);
        root.lt = new Nodee(2);
        root.rt = new Nodee(3);
        root.lt.lt = new Nodee(4);
        root.lt.rt = new Nodee(5);

        System.out.println(BFS(root));
    }

    public static int BFS(Nodee root) {
        Queue<Nodee> q = new LinkedList<>();

        q.offer(root);
        int level = 0;

        while (true) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                Nodee tmp = q.poll();
                if (tmp.lt == null && tmp.rt == null) { // 말단 노드일 경우에,
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
    }

}
