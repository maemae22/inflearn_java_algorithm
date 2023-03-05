import java.util.*;

public class 덱_스택_큐_우선순위큐_사용법 {

    // ⭐ 1. 덱
    public static void main(String[] args) {
        Deque<Node> deque = new LinkedList<>();

        deque.addFirst(new Node(2, 3)); // 첫번째에 삽입
        deque.removeFirst(); // 첫번째꺼 삭제
        deque.addLast(new Node(2, 3)); // 마지막에 삽입
        deque.removeLast(); // 마지막꺼 삭제

        // 예시
        while (!deque.isEmpty() && deque.getLast().value > 3) {
            deque.removeLast();
        }
        deque.addLast(new Node(2, 3));

        if (7 - deque.getFirst().index >= 4 ) {
            deque.removeFirst();
        }

        System.out.println(deque.getFirst().value + " ");

    }

    static class Node {
        public int value;
        public int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    // ⭐ 2. 스택 : 깊이 우선 탐색(DFS), 백트래킹 종류의 코테에서 많이 쓰임 (후입선출 LIFO : 재귀 함수 알고리즘 원리와 비슷)
    public static void main2(String[] args) {

        // Stack 선언
        Stack<Integer> stack = new Stack<>(); // int형 스택 선언
        Stack<String> stack2 = new Stack<>(); // char형 스택 선언

        // Stack 값 추가 : push(value)
        stack.push(1);     // stack에 값 1 추가
        stack.push(2);     // stack에 값 2 추가
        stack.push(3);     // stack에 값 3 추가

        // Stack 값 삭제 : pop() / clear() - 스택의 값을 모두 제거
        stack.pop();       // stack에 값 제거 (삭제+확인)
        stack.clear();     // stack의 전체 값 제거 (초기화)

        // Stack의 가장 상단의 값 출력
        stack.peek();     // stack의 가장 상단의 값 출력(확인)

        // Stack의 기타 메서드
        stack.size();      // stack의 크기 출력
        stack.empty();     // stack이 비어있는지 check (비어있다면 true)
        stack.isEmpty();   // stack이 비어있는지 check (비어있다면 true)
        stack.contains(1); // stack에 1이 있는지 check (있다면 true)

        /*
        [위치]
        top : 삽입과 삭제가 일어나는 위치
        [연산]
        push : top 위치에 새로운 데이터를 삽입하는 연산
        pop : top 위치에 현재 있는 데이터를 삭제하고 확인하는 연산
        peek : top 위치에 현재 있는 데이터를 단순 확인하는 연산
         */
    }

    // ⭐ 3. 큐 : 삽입과 삭제 연산이 선입선출 FIFO, 너비 우선 탐색(BFS)에서 자주 사용
    public static void main3(String[] args) {

        // Queue 선언 : 자바에서 큐는 LinkedList를 활용하여 생성해야 한다.
        //              Queue<Element> queue = new LinkedList<>(); 와 같이 선언
        Queue<Integer> queue = new LinkedList<>(); // int형 queue 선언, linkedlist 이용
        Queue<String> queue2 = new LinkedList<>(); // String형 queue 선언, linkedlist 이용

        // Queue 값 추가 : add(value) 또는 offer(value)
        // add(value) : 삽입에 성공하면 true를 반환, 큐에 여유 공간이 없어 삽입 실패 시 IllegalStateException 발생
        queue.add(1);     // queue에 값 1 추가
        queue.add(2);     // queue에 값 2 추가
        queue.offer(3);   // queue에 값 3 추가

        // Queue 값 삭제 : poll() / remove() / clear()
        queue.poll();       // queue에 첫번째 값을 반환하고 제거, 비어있다면 null 반환
        queue.remove();     // queue에 첫번째 값 제거
        queue.clear();      // queue 초기화 (queue의 모든 요소를 제거)

        // Queue 에서 가장 먼저 들어간 값 출력 : peek() - Queue에서 첫번째로 저장된 값을 참조
        queue.peek();       // queue의 첫번째 값 참조

        // Queue의 기타 메서드
        queue.size();
        queue.isEmpty();
        queue.contains(3);

        /*
        [위치]
        rear : 큐에서 가장 끝 데이터를 가리키는 영역 - 삽입 연산만 수행
        front : 큐에서 가장 앞의 데이터를 가리키는 영역 - 삭제 연산만 수행
        [연산]
        add : rear 부분에 새로운 데이터를 삽입하는 연산
        poll : front 부분에 있는 데이터를 삭제하고 확인하는 연산
        peek : 큐의 맨 앞(front)에 있는 데이터를 확인할 때 사용하는 연산
         */
    }

    // ⭐ 4. 우선순위 큐 : 값이 들어간 순서와 상관 없이 우선순위가 높은 데이터가 먼저 나오는 자료구조
    // 우선순위 큐 설정에 따라 front에 항상 최댓값 또는 최솟값이 위치함

    /*
    - Priority Queue의 특징
    1. 높은 우선순위의 요소를 먼저 꺼내서 처리하는 구조 (큐에 들어가는 원소는 비교가 가능한 기준이 있어야함)
    2. 내부 요소는 힙으로 구성되어 이진트리 구조로 이루어져 있음
    3. 내부구조가 힙으로 구성되어 있기에 시간 복잡도는 O(NLogN)
    4. 응급실과 같이 우선순위를 중요시해야 하는 상황에서 쓰임
     */
    public static void main4(String[] args) {

        // Priority Queue 선언 : PriorityQueue<Element> queue = new PriorityQueue<>(); 와 같은 형식으로 선언 - 기본 오름차순
        //                      내림차순 정렬 원하면 선언 시 Collections.reverseOrder() 메서드를 활용
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); // int형 priorityQueue 선언 (우선순위 : 오름차순)
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(Collections.reverseOrder()); // int형 priorityQueue 선언 (내림차순)
        PriorityQueue<String> priorityQueue3 = new PriorityQueue<>(); // String형 priorityQueue 선언 (오름차순)
        PriorityQueue<String> priorityQueue4 = new PriorityQueue<>(Collections.reverseOrder()); // String형 priorityQueue 선언 (내림차순)

        // Priority Queue 값 추가 : add(value) 또는 offer(value)
        // add(value) : 삽입에 성공하면 true를 반환, 큐에 여유 공간이 없어 삽입 실패 시 IllegalStateException 발생
        // 우선순위 큐에 값을 추가한다면, 정해진 우선순위에 따라 즉시 정렬됨.
        priorityQueue.add(1);     // priorityQueue 값 1 추가
        priorityQueue.add(2);     // priorityQueue 값 2 추가
        priorityQueue.offer(3);   // priorityQueue 값 3 추가

        // Priority Queue 값 삭제 : poll() 또는 remove() - 값을 제거할 시 우선순위가 가장 높은 값이 제거됨.
        priorityQueue.poll();       // priorityQueue에 첫번째 값을 반환하고 제거, 비어있다면 null 반환
        priorityQueue.remove();     // priorityQueue에 첫번째 값 제거 (가장 앞쪽에 있는 원소의 값이 제거)
        priorityQueue.clear();      // priorityQueue에 초기화 (queue의 모든 요소를 제거)

        // Priority Queue에서 우선순위가 가장 높은 값 출력 : peek() - Priority Queue에서 우선순위가 가장 높은 값을 참조
        priorityQueue.offer(2);     // priorityQueue에 값 2 추가
        priorityQueue.offer(1);     // priorityQueue에 값 1 추가
        priorityQueue.offer(3);     // priorityQueue에 값 3 추가
        priorityQueue.peek();       // priorityQueue에 첫번째 값 참조 = 1 (우선순위가 가장 높은 1이 출력)

    }

    public static void main4_ex(String[] args) {

        // 예시
        // 우선순위 큐 선언. 정렬 기준을 새로 적용하기.
        // 사용자 지정 기준 : 1. 절댓값 기준으로 정렬 / 2. 절댓값이 같으면 음수 우선 정렬
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int first = Math.abs(o1);
            int second = Math.abs(o2);

            if(first == second) {
                return o1 > o2? 1 : -1; // 절댓값이 같으면 음수 우선 정렬
            } else {
                return first - second; // 절댓값 기준으로 정렬
            }
        });
    }
}
