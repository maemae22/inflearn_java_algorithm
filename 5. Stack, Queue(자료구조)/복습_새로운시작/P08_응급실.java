package 복습_새로운시작;

import java.util.*;
import java.io.*;

public class P08_응급실 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Integer[] arr = new Integer[N];
        Queue<Patient> q = new LinkedList<>();
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            q.offer(new Patient(arr[i], i));
        }
        Arrays.sort(arr, Collections.reverseOrder());

        int index = 0;
        int answer = 0;
        while (true) {
            Patient tmp = q.poll();
            if (tmp.danger==arr[index]) {
                answer++;
                index++;
                if (tmp.num==M) {
                    break;
                }
            } else {
                q.offer(tmp);
            }
        }

        System.out.println(answer);
    }
}

class Patient {
    int danger;
    int num;
    Patient(int danger, int num) {
        this.danger = danger;
        this.num = num;
    }
}
