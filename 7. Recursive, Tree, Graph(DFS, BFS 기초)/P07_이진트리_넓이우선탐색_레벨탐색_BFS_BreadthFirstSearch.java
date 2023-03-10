import java.util.*;
import java.io.*;

// 아래 그림과 같은 이진트리를 레벨탐색 연습하세요.                   1
// 레벨 탐색 순회 출력 : 1 2 3 4 5 6 7                       2   |     3
//                                                      4 | 5     6 | 7
public class P07_이진트리_넓이우선탐색_레벨탐색_BFS_BreadthFirstSearch {

    static Noode root;

    public static void main(String[] args) throws Exception {

        root = new Noode(1);
        root.lt = new Noode(2);
        root.rt = new Noode(3);
        root.lt.lt = new Noode(4);
        root.lt.rt = new Noode(5);
        root.rt.lt = new Noode(6);
        root.rt.rt = new Noode(7);

        BFS(root);
    }

    public static void BFS(Noode root) {
        Queue<Noode> q = new LinkedList<>();

        // 0레벨 넣어줌 (0레벨 설정)
        q.offer(root);
        int level = 0;

        while (!q.isEmpty()) {
            // 이거 반복문 1번이 한 레벨 도는거임 .. !
            System.out.print("현재 level은 = " + level + " : ");

            int size = q.size();
            for (int i=0; i<size; i++) {
                Noode tmp = q.poll();
                System.out.print(tmp.data+" ");

                if (tmp.lt != null) {
                    q.offer(tmp.lt);
                }
                if (tmp.rt != null) {
                    q.offer(tmp.rt);
                }
            }

            level++;
            System.out.println(); // 한 레벨 출력이 다 끝나면 줄바꿈
        }
    }

    /*
    출력 결과 :
    현재 level은 = 0 : 1
    현재 level은 = 1 : 2 3
    현재 level은 = 2 : 4 5 6 7
     */
}

class Noode {
    int data;
    Noode lt;
    Noode rt;

    public Noode(int data) {
        this.data = data;
        lt = null;
        rt = null;
    }
}
