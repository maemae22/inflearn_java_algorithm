import java.util.*;
import java.io.*;

/*
N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.
ex.
5
2 7
1 3
1 2
2 5
3 6
->
1 2
1 3
2 5
2 7
3 6
 */
public class P07_좌표정렬 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer("");
        ArrayList<Dot> list = new ArrayList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // ⭐ ArrayList 정렬 : Collections.sort(list);
        Collections.sort(list);

        for (Dot one : list) {
            System.out.println(one.x + " " + one.y);
        }
    }
}

class Dot implements Comparable<Dot> {
    int x;
    int y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // ⭐ 객체 정렬하는 방법 !
    // implements Comparable<Dot> 하고, @Override public int compareTo(Dot o) { } 오버라이드 !!
    // 오름차순 정렬하고 싶으면, 앞에서 뒤에꺼를 빼면 됨 (ex. return this.x - o.x; )
    // 내림차순일 경우에는 반대로 빼기 ! (ex. return o.x - this.x; )
    @Override
    public int compareTo(Dot o) {
        if (this.x != o.x) {
            return this.x - o.x;
        } else {
            return this.y - o.y;
        }
    }
}
