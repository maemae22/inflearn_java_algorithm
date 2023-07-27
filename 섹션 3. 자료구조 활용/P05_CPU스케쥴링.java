import java.util.*;

public class P05_CPU스케쥴링 {
    public int[] solution(int[][] tasks) {
        int[] answer = new int[tasks.length];
        int time = 0;
        int count = 0;
        TreeSet<WaitCpu> wait = new TreeSet<>();
        List<AllCpu> all = new ArrayList<>();

        for (int i=0; i<tasks.length; i++) {
            all.add(new AllCpu(i, tasks[i][0], tasks[i][1]));
        }
        Collections.sort(all);

        while (count < tasks.length) {
            if (wait.isEmpty() && !all.isEmpty()) {
                time = all.get(0).start;
            } else {
                WaitCpu tmp = wait.pollFirst();
                time += tmp.time;
                answer[count++] = tmp.num;
            }

            while (count<tasks.length && !all.isEmpty()) {
                AllCpu tmp = all.get(0);
//                System.out.println(tmp.num + "/" + tmp.start + "/" + tmp.time);
                if (tmp.start<=time) {
                    all.remove(0);
                    wait.add(new WaitCpu(tmp.num, tmp.start, tmp.time));
                } else {
                    all.add(0, tmp);
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P05_CPU스케쥴링 T = new P05_CPU스케쥴링();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }
}

class WaitCpu implements Comparable<WaitCpu> {
    int num;
    int start;
    int time;
    WaitCpu(int num, int start, int time) {
        this.num = num;
        this.start = start;
        this.time = time;
    }

    @Override
    public int compareTo(WaitCpu o) {
        if (o.time != this.time) {
            return this.time - o.time;
        } else {
            return this.num - o.num;
        }
    }
}

class AllCpu implements Comparable<AllCpu> {
    int num;
    int start;
    int time;
    AllCpu(int num, int start, int time) {
        this.num = num;
        this.start = start;
        this.time = time;
    }

    @Override
    public int compareTo(AllCpu o) {
        return this.start - o.start;
    }
}
