import java.util.*;

public class P03_현관문출입순서 {
    public int[] solution(int[] arrival, int[] state) {
        int N = arrival.length;

        Queue<Worker> in = new LinkedList<>();
        Queue<Worker> out = new LinkedList<>();
        for (int i=0; i<N; i++) {
            if (state[i]==0) {
                in.add(new Worker(i, arrival[i], state[i]));
            } else {
                out.add(new Worker(i, arrival[i], state[i]));
            }
        }

        int now = arrival[0];
        int recent = 1;
        boolean find = false;

        int[] answer = new int[N];
        while (!in.isEmpty() || !out.isEmpty()) {
            find = false;
            if (recent==1) {
                if (!out.isEmpty() && out.peek().time<=now) {
                    Worker pick = out.poll();
                    answer[pick.num] = now++;
                    find = true;
                    recent = 1;
                }
                if (!find) {
                    if (!in.isEmpty() && in.peek().time<=now) {
                        Worker pick = in.poll();
                        answer[pick.num] = now++;
                        find = true;
                        recent = 0;
                    }
                }
            }

            if (recent==0) {
                if (!in.isEmpty() && in.peek().time<=now) {
                    Worker pick = in.poll();
                    answer[pick.num] = now++;
                    find = true;
                    recent = 0;
                }
                if (!find) {
                    if (!out.isEmpty() && out.peek().time<=now) {
                        Worker pick = out.poll();
                        answer[pick.num] = now++;
                        find = true;
                        recent = 1;
                    }
                }
            }

            if (!find) {
                recent = 1;
                now++;
            }
        }

        return answer;
    }

    public int[] solution2(int[] arrival, int[] state) {
        int[] answer = new int[arrival.length];
        Queue<Integer> in = new LinkedList<>();
        Queue<Integer> out = new LinkedList<>();

        int now = arrival[0];
        int recent = 1;

        int index = 0;
        while (index<=arrival.length) {
            while (index<arrival.length && arrival[index]<=now) {
                if (state[index]==1) {
                    out.offer(index++);
                } else {
                    in.offer(index++);
                }
            }

            if (recent==1 && !out.isEmpty()) {
                recent = 1;
                answer[out.poll()]=now++;
            } else if (recent==1 && out.isEmpty() && !in.isEmpty()) {
                recent = 0;
                answer[in.poll()]=now++;
            } else if (recent==0 && !in.isEmpty()) {
                recent = 0;
                answer[in.poll()]=now++;
            } else if (recent==0 && in.isEmpty() && !out.isEmpty()) {
                recent = 1;
                answer[out.poll()]=now++;
            } else {
                recent = 1;
                now++;
            }

            if (index==arrival.length && in.isEmpty() && out.isEmpty()) {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P03_현관문출입순서 T = new P03_현관문출입순서();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
        System.out.println();
        System.out.println(Arrays.toString(T.solution2(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution2(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution2(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}

class Worker {
    int num;
    int time;
    int state;
    Worker (int num, int time, int state) {
        this.num = num;
        this.time = time;
        this.state = state;
    }
}
