import java.util.*;
import java.io.*;

/*
• 환자가 접수한 순서대로의 목록에서 제일 앞에 있는 환자목록을 꺼냅니다.
• 나머지 대기 목록에서 꺼낸 환자 보다 위험도가 높은 환자가 존재하면 대기목록 제일 뒤로 다시 넣습니다. 그렇지 않으면 진료를 받습니다.
즉 대기목록에 자기 보다 위험도가 높은 환자가 없을 때 자신이 진료를 받는 구조입니다.
M번째 환자의 몇 번째로 진료받는지 출력하세요.
ex1.
5 2
60 50 70 80 90
-> 3
ex2.
6 3
70 60 90 60 60 60
-> 4
 */
public class P08_응급실 {
    public static void main(String[] args) throws Exception {
        // 초기세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Queue<Person> queue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            queue.add(new Person(i, Integer.parseInt(st.nextToken())));
        }

        // 로직
        int count = 0;
        while(!queue.isEmpty()) {
            Person tmp = queue.poll();
            for (Person rest : queue) {
                if (rest.priority > tmp.priority) {
                    queue.offer(tmp);
                    tmp = null;
                    break;
                }
            }

            if (tmp != null) { // Queue에서 꺼낸 것이 우선순위가 제일 높은 환자가 맞았을 경우
                if (tmp.num == M) { // 내가 찾던 환자이면
                    count++;
                    break;
                } else { // 아니면
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}

class Person {
    int num;
    int priority;

    public Person(int num, int priority) {
        this.num = num;
        this.priority = priority;
    }
}
