import java.util.*;
import java.io.*;

// 이진트리에서 루트 노드 1에서 말단노드까지의 길이 중 가장 짧은 길이를 구하는 프로그램을 작성하세요.
// 각 경로의 길이는 루트노드에서 말단노드까지 가는데 이동하는 횟수를, 즉 간선(에지)의 개수를 길이로 하겠습니다.
// ex. 가장 짧은 길이는 3번 노드까지의 길이인 1이다.
public class P09_Tree말단노드까지의가장짧은경로_DFS {

    public static void main(String[] args) throws Exception {
        Nodee root = new Nodee(1);
        root.lt = new Nodee(2);
        root.rt = new Nodee(3);
        root.lt.lt = new Nodee(4);
        root.lt.rt = new Nodee(5);

        System.out.println(DFS(0, root));
    }

    // 루트노드에서 말단노드까지 가는데 이동하는 횟수를 나타내는 함수
    public static int DFS(int level, Nodee root) {
        if (root.lt == null && root.rt == null) { // 말단 노드일 경우에,
            return level;
        } else {
            return Math.min( DFS(level+1, root.lt), DFS(level+1, root.rt) );
        }
    }
}

class Nodee {
    int data;
    Nodee lt;
    Nodee rt;

    public Nodee(int data) {
        this.data = data;
        lt = null;
        rt = null;
    }
}
