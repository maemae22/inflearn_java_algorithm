import java.util.*;

public class P02_줄다리기 {

    static int answer;
    static HashMap<Integer, ArrayList<Integer>> hate;

    public int solution(int[][] fight) {
        answer = 0;
        hate = new HashMap<>();
        for (int i=0; i<=7; i++) {
            hate.put(i, new ArrayList<>());
        }

        for (int i=0; i<fight.length; i++) {
            int a = fight[i][0];
            int b = fight[i][1];

            ArrayList<Integer> aput = hate.get(a);
            aput.add(b);
            hate.put(a, aput);

            ArrayList<Integer> bput = hate.get(b);
            bput.add(a);
            hate.put(b, bput);
        }

        DFS(0, new int[8], 0);
        return answer;
    }

    public void DFS(int count, int[] check, int pri) {
        if (count==7) {
            answer++;
        } else {
            for (int i=1; i<8; i++) {
                if (check[i]==0 && !hate.get(pri).contains(i)) {
                    check[i]=1;
                    DFS(count+1, check, i);
                    check[i]=0;
                }
            }
        }
    }

    static int[][] arr;
    public int solution2(int[][] fight) {
        answer = 0;
        arr = new int[8][8];

        for (int i=0; i<fight.length; i++) {
            int a = fight[i][0];
            int b = fight[i][1];
            arr[a][b]=1;
            arr[b][a]=1;
        }

        DFS2(0, new int[8], 0);
        return answer;
    }

    public void DFS2(int count, int[] check, int pri) {
        if (count==7) {
            answer++;
        } else {
            for (int i=1; i<8; i++) {
                if (check[i]==0 && arr[pri][i]!=1) {
                    check[i]=1;
                    DFS2(count+1, check, i);
                    check[i]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        P02_줄다리기 T = new P02_줄다리기();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
        System.out.println();
        System.out.println(T.solution2(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution2(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution2(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution2(new int[][]{{1, 7}}));
        System.out.println(T.solution2(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}
