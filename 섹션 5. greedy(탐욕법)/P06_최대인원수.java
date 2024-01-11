import java.util.*;

public class P06_최대인원수 {
    public int solution(int n, int[][] trans, int[][] bookings) {
        int[] road = new int[n];
        for (int i=0; i<trans.length; i++) {
            for (int j=trans[i][0]; j<trans[i][1]; j++) {
                road[j] += trans[i][2];
            }
        }

        List<Train> list = new ArrayList<>();
        for (int[] tmp : bookings) {
            list.add(new Train(tmp[0], tmp[1]));
        }
        Collections.sort(list);

        int answer = 0;
        for (Train tmp : list) {
            boolean can = true;
            for (int i=tmp.start; i<tmp.end; i++) {
                if (road[i]<1) {
                    can = false;
                    break;
                }
            }
            if (can) {
                for (int i=tmp.start; i<tmp.end; i++) {
                    road[i]--;
                }
                answer++;
            }
        }

        return answer;
    }

    public int solution2(int n, int[][] trans, int[][] bookings) {
        int[] sum = new int[n+1];
        for (int[] tmp : trans) {
            sum[tmp[0]] += tmp[2];
            sum[tmp[1]] -= tmp[2];
        }

        for (int i=1; i<=n; i++) {
            sum[i] = sum[i-1] + sum[i];
        }

        List<Child> list = new ArrayList<>();
        for (int[] tmp : bookings) {
            list.add(new Child(tmp[0], tmp[1]));
        }
        Collections.sort(list);

        int answer = 0;
        int index = 0;
        List<Integer> remain = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            while (!remain.isEmpty() && remain.get(0)==i) { // 내리는 어린이
                answer++;
                remain.remove(0);
            }

            while (index<list.size() && list.get(index).start==i) { // 타는 어린이
                remain.add(list.get(index).end);
                index++;
            }
            Collections.sort(remain);

            while (sum[i]<remain.size()) { // 인원 초과일 경우 out
                remain.remove(remain.size()-1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P06_최대인원수 T = new P06_최대인원수();
        System.out.println(T.solution(5, new int[][]{{1, 4, 2}, {2, 5, 1}}, new int[][]{{1, 2}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {2, 5}, {3, 5}, {3, 4}}));
        System.out.println(T.solution(5, new int[][]{{2, 3, 1}, {1, 5, 1}}, new int[][]{{2, 5}, {1, 5}, {1, 3}, {2, 4}, {2, 5}, {2, 3}}));
        System.out.println(T.solution(8, new int[][]{{1, 8, 3}, {3, 8, 1}}, new int[][]{{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}}));
        System.out.println(T.solution(9, new int[][]{{1, 8, 3}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {5, 8}, {2, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {7, 8}, {5, 8}, {3, 5}, {3, 7}, {4, 7}, {5, 8}}));
        System.out.println(T.solution(9, new int[][]{{2, 7, 2}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {4, 8}, {2, 9}, {5, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {3, 6}, {7, 8}, {5, 8}, {3, 5}, {2, 7}, {1, 7}, {2, 8}}));
        System.out.println();
        System.out.println(T.solution2(5, new int[][]{{1, 4, 2}, {2, 5, 1}}, new int[][]{{1, 2}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {2, 5}, {3, 5}, {3, 4}}));
        System.out.println(T.solution2(5, new int[][]{{2, 3, 1}, {1, 5, 1}}, new int[][]{{2, 5}, {1, 5}, {1, 3}, {2, 4}, {2, 5}, {2, 3}}));
        System.out.println(T.solution2(8, new int[][]{{1, 8, 3}, {3, 8, 1}}, new int[][]{{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}}));
        System.out.println(T.solution2(9, new int[][]{{1, 8, 3}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {5, 8}, {2, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {7, 8}, {5, 8}, {3, 5}, {3, 7}, {4, 7}, {5, 8}}));
        System.out.println(T.solution2(9, new int[][]{{2, 7, 2}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {4, 8}, {2, 9}, {5, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {3, 6}, {7, 8}, {5, 8}, {3, 5}, {2, 7}, {1, 7}, {2, 8}}));
    }
}

class Train implements Comparable<Train> {
    int start;
    int end;
    Train(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Train o) {
        return this.end-this.start-(o.end-o.start);
    }
}

class Child implements Comparable<Child> {
    int start;
    int end;
    Child(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Child o) {
        return this.start - o.start;
    }
}
