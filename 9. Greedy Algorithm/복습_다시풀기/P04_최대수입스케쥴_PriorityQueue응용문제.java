package 복습_다시풀기;

import java.util.*;
import java.io.*;

public class P04_최대수입스케쥴_PriorityQueue응용문제 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Work> list = new ArrayList<>();
        int maxDue = 0;
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int due = Integer.parseInt(st.nextToken());
            list.add(new Work(money, due));
            maxDue = Math.max(maxDue, due);
        }

        int[] check = new int[maxDue+1];
        int answer = 0;
        Collections.sort(list);

        for (Work work : list) {
            for (int i=work.due; i>0; i--) {
                if (check[i]==0) {
                    check[i]=1;
                    answer+=work.money;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}

class Work implements Comparable<Work> {
    int money;
    int due;
    Work(int money, int due) {
        this.money = money;
        this.due = due;
    }
    @Override
    public int compareTo(Work o) {
        return this.money!=o.money ? o.money-this.money : o.due-this.due;
    }
}