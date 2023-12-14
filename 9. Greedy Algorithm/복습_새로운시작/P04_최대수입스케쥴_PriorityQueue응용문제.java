package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P04_최대수입스케쥴_PriorityQueue응용문제 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Day> days = new PriorityQueue<>();
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            days.offer(new Day(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int answer = 0;
        PriorityQueue<Play> pQ = new PriorityQueue<>();
        int maxDay=days.peek().day;
        for (int i=maxDay; i>=1; i--) {
            while (!days.isEmpty() && days.peek().day>=i) {
                Day tmp = days.poll();
                pQ.offer(new Play(tmp.money, tmp.day));
            }
            if (!pQ.isEmpty()) {
                answer += pQ.poll().money;
            } else {
                i = days.peek().day+1;
            }
        }

        System.out.println(answer);
    }
}

class Play implements Comparable<Play> {
    int money;
    int day;
    Play(int money, int day) {
        this.money = money;
        this.day = day;
    }

    @Override
    public int compareTo(Play o) {
        return o.money!=this.money ? o.money-this.money : this.day-o.day;
    }

    public String toString() {
        return this.day+"안에 오면 "+this.money;
    }
}

class Day implements Comparable<Day> {
    int money;
    int day;
    Day(int money, int day) {
        this.money = money;
        this.day = day;
    }

    @Override
    public int compareTo(Day o) {
        return o.day-this.day;
    }
}
