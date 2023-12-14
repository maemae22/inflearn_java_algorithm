package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P03_결혼식 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Person> list = new ArrayList<>();
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Person(Integer.parseInt(st.nextToken()), 'b'));
            list.add(new Person(Integer.parseInt(st.nextToken()), 'a'));
        }

        Collections.sort(list);

        int now = 0;
        int answer = 0;
        for (Person tmp : list) {
            if (tmp.state=='a') {
                now--;
            } else if (tmp.state=='b') {
                now++;
            }
            answer = Math.max(answer, now);
        }

        System.out.println(answer);
    }
}

class Person implements Comparable<Person> {
    int time;
    char state;
    Person(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Person o) {
        return this.time!=o.time ? this.time-o.time : this.state-o.state;
    }
}
