import java.util.*;
import java.io.*;

/*
현수는 유명한 강연자이다. N개의 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.
각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.
단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.
첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.
첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.
ex.
6
50 2
20 1
40 2
60 3
30 3
30 1
->
150
 */
public class P04_최대수입스케쥴_PriorityQueue응용문제 {

    public static void main(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Lesson> list = new ArrayList<>();
        int maxDue = 0;
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int due = Integer.parseInt(st.nextToken());
            maxDue = Math.max(due, maxDue);
            list.add(new Lesson(pay, due));
        }

        // 로직
        Collections.sort(list);
//        System.out.println(list);

        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder()); // 강연료가 내림차순 정렬되도록 만듦 !
        int sum = 0;
        int j = 0;
        for (int i=maxDue; i>0; i--) {
            for ( ; j<N; j++) {
                if (list.get(j).due >= i) {
                    pQ.offer(list.get(j).pay);
                } else {
                    break;
                }
            }
            if (!pQ.isEmpty()) {
                sum += pQ.poll();
            }
        }

        // 출력
        System.out.println(sum);
    }
}

class Lesson implements Comparable<Lesson> {
    int pay;
    int due;

    public Lesson(int pay, int due) {
        this.pay = pay;
        this.due = due;
    }

    // due 내림차순, due가 같다면 pay 내림차순으로 정렬함.
    @Override
    public int compareTo(Lesson o) {
        if (this.due != o.due) {
            return o.due - this.due;
        } else {
            return o.pay - this.pay;
        }
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "pay=" + pay +
                ", due=" + due +
                '}';
    }
}
