import java.util.*;

public class P04_피부과 {
    public int solution(int[] laser, String[] enter) {

        int[] enterTime = new int[enter.length];
        int[] enterLaser = new int[enter.length];
        for (int i=0; i<enter.length; i++) {
            String time = enter[i].split(" ")[0];
            enterTime[i] = stringTimeToInt(time);
            enterLaser[i] = laser[Integer.parseInt(enter[i].split(" ")[1])];
        }

        int answer = 0;
        int now = 1; // 현재 몇명 대기하고 있는지
        int index = 0; // 치료받을 사람
        int time = enterTime[0]; // 현재 시간
        int wait = 1; // 대기 몇번까지

        while (index<enter.length) {
            if (enterTime[index]<=time) {
                now--;
                time += enterLaser[index++];
            } else {
                time = enterTime[index] + enterLaser[index++];
                wait++;
            }
            while (wait<enter.length && enterTime[wait]<time) {
                now++;
                wait++;
            }
            answer = Math.max(answer, now);
        }

        return answer;
    }

    public int stringTimeToInt(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3));
        return hour*60+minute;
    }

    public static void main(String[] args) {
        P04_피부과 T = new P04_피부과();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}
