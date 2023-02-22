import java.util.*;
import java.io.*;

// 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
// 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
// ex. 20 -> 8
public class P05_소수_에라토스테네스체 {

    // 방법1. 이중 for문 전체 돌기 (시간 초과 Time Limit Exceeded)
    public static void main1(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 1;
        boolean sosu = true;

        for (int i=3; i<=N; i++) {
            for (int j=2; j<i; j++) {
                if (i%j == 0) {
                    sosu = false;
                    break;
                }
            }

            if (sosu) {
                answer++;
            } else {
                sosu = true;
            }
        }

        System.out.println(answer);
    }

    // 방법2. 이중 for문 반만 돌기 (시간 초과 Time Limit Exceeded)
    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 1;
        boolean sosu = true;

        for (int i=3; i<=N; i++) {
            for (int j=2; j<=i/2; j++) {
                if (i%j == 0) {
                    sosu = false;
                    break;
                }
            }

            if (sosu) {
                answer++;
            } else {
                sosu = true;
            }
        }

        System.out.println(answer);
    }

    // 방법3. 이중 for문 제곱근까지만 돌기 (정답, 시간초과 안남)
    public static void main3(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 1;
        boolean sosu = true;

        for (int i=3; i<=N; i++) {
            for (int j=2; j<=Math.sqrt(i); j++) {
                if (i%j == 0) {
                    sosu = false;
                    break;
                }
            }

            if (sosu) {
                answer++;
            } else {
                sosu = true;
            }
        }

        System.out.println(answer);
    }

    // 방법4. 에라토스테네스 체 방법 : 배열을 만들고, 배수를 체크 (가장 빠름, 제곱근보다 빠름)
    public static void main4(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sosu = new int[N+1]; // index 번호를 N번까지 만들기 위하여, 크기가 N+1인 배열을 생성
        int answer = 0;

        for (int i=2; i<=N; i++) {
            if (sosu[i] == 0) {
                answer++;

                // i의 배수들의 index의 배열 값을 0이 아닌 수로 바꾼다 !! (핵심)
                /*
                // 방법4-1. 시간초과ㅠ - 별로임 .. (Time Limit Exceeded)
                for (int j=i+1; j<=N; j++) {
                    if (j%i==0) {
                        sosu[j]++;
                    }
                }
                 */

                // 방법4-2. 에라토스테네스 체 (이 방법이 좋음 !)
                for (int j=i; j<=N; j=j+i) {
                    sosu[j]++;
                }
            }
        }

        System.out.println(answer);
    }
}
