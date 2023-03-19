import java.util.*;
import java.io.*;

/*
한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들려고 한다.
각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.
단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
ex1.
5
1 4
2 3
3 5
4 6
5 7
->
3
ex2.
3
3 3
1 3
2 3
->
2
 */
public class P02_회의실배정 {

    public static void main(String[] args) throws Exception {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Meeting> meetings = new ArrayList<>();
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(start, end));
        }

        // 로직

        // 회의 시간을 끝나는 시간을 기준으로 오름차순 정렬, 만약 끝나는 시간이 같다면 시작 시간으로 오름차순 정렬.
        Collections.sort(meetings);

        int answer = 0;
        int tmpEnd = 0;
        for (Meeting meeting : meetings) {
            if (meeting.start >= tmpEnd) {
                answer++;
                tmpEnd = meeting.end;
            }
        }

        // 출력
        System.out.println(answer);
    }
}

class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    // 끝나는 시간을 기준으로 오름차순 정렬, 만약 끝나는 시간이 같다면 시작 시간으로 오름차순 정렬한다.
    @Override
    public int compareTo(Meeting o) {
        if (this.end != o.end) {
            return this.end - o.end;
        } else {
            return this.start - o.start;
        }
    }
}
