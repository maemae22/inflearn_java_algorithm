import java.util.*;

public class P05_모임장소 {
    public int solution(int[][] board) {
        List<Integer> locX = new ArrayList<>();
        List<Integer> locY = new ArrayList<>();

        int n = board.length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j]==1) {
                    locX.add(i);
                    locY.add(j);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                int sum = 0;
                for (int k=0; k<locX.size(); k++) {
                    sum += Math.abs(locX.get(k)-i);
                    sum += Math.abs(locY.get(k)-j);
                }
                answer = Math.min(answer, sum);
            }
        }

        return answer;
    }

    public int solution2(int[][] board) {
        List<Integer> locX = new ArrayList<>();
        List<Integer> locY = new ArrayList<>();

        int n = board.length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j]==1) {
                    locX.add(i);
                    locY.add(j);
                }
            }
        }

        int nums = locX.size();
        Collections.sort(locY);
        int targetX = locX.get(nums/2);
        int targetY = locY.get(nums/2);

        int answer = 0;
        for (int i=0; i<nums; i++) {
            answer += Math.abs(locX.get(i)-targetX);
            answer += Math.abs(locY.get(i)-targetY);
        }

        return answer;
    }

    public static void main(String[] args) {
        P05_모임장소 T = new P05_모임장소();
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
        System.out.println();
        System.out.println(T.solution2(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution2(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(T.solution2(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }
}
