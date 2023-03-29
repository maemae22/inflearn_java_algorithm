import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Set컬렉션_HashSet_TreeSet_사용법 {

    // Set 컬렉션 ( HashSet, TreeSet )
    // 저장 순서가 유지X, 객체를 중복해서 저장X, 하나의 null만 저장 가능

    // ⭐ HashSet 사용법 & 예제 ⭐
    public static void main(String[] args) {

        // ⭐ HashSet 선언 : HashSet<Integer> set2 = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<Integer>(); // HashSet 생성
        HashSet<Integer> set2 = new HashSet<>(); // new에서 타입 파라미터 생략 가능
        HashSet<Integer> set3 = new HashSet<Integer>(set1); // set1의 모든 값을 가진 HashSet 생성
        HashSet<Integer> set4 = new HashSet<Integer>(10); // 초기 용량(capacity) 지정
        HashSet<Integer> set5 = new HashSet<Integer>(10, 0.7f); // 초기 capacity, load factor 지정
        HashSet<Integer> set6 = new HashSet<Integer>(Arrays.asList(1,2,3)); // 초기값 지정

        // ⭐ HashSet 값 추가 : add(value) 메소드
        HashSet<Integer> set = new HashSet<Integer>(); // HashSet 생성
        set.add(1); // 값 추가
        set.add(2);
        set.add(3);

        // ⭐ HashSet 값 삭제 : remove(value) 메소드 / clear() 메소드
        HashSet<Integer> sets = new HashSet<Integer>(Arrays.asList(1,2,3)); // HashSet 생성
        sets.remove(1); // 값 1 제거
        sets.clear(); // 모든 값 제거

        if(sets.isEmpty()) { // isEmpty()
            System.out.println("비었습니다.");
        }

        // ⭐ HashSet 크기 구하기 : size() 메소드
        HashSet<Integer> set7 = new HashSet<Integer>(Arrays.asList(1,2,3)); // HashSet 생성
        System.out.println(set7.size()); // set 크기 : 3

        // ⭐ HashSet 값 출력
        System.out.println(set7); // 전체 출력 : [1,2,3]

        Iterator iter = set7.iterator(); // Iterator 사용
        while(iter.hasNext()) { // 값이 있으면 true, 없으면 false
            System.out.println(iter.next());
        }

        for (int num : set7) { // 향상된 for문 이용
            System.out.println(num);
        }

        // ⭐ HashSet 값 검색 : contains(value) 메소드
        System.out.println(set7.contains(1)); // set 내부에 값 1이 있는지 check : true

    }

    // ⭐ TreeSet 사용법 & 예제 ⭐
    // TreeSet : 이진 탐색 트리(BinarySearchTree) 구조로 이루어져 있음
    // 자동 정렬 - 부모값과 비교해서 낮은 것은 왼쪽 자식 노드에, 높은 것은 오른쪽 자식 노드에 저장
    // 정렬, 검색에 높은 성능을 보이는 자료구조, HashSet보다 데이터의 추가와 삭제는 시간이 더 걸리지만 검색과 정렬에는 유리
    public static void main2(String[] args) {

        // ⭐ TreeSet 선언 : TreeSet<Integer> set2 = new TreeSet<>();
        // 생성하는 명령어는 HashSet과 크게 다르지 않으나, 선언 시 크기를 지정해줄 수는 없다.
        TreeSet<Integer> set1 = new TreeSet<Integer>(); // TreeSet 생성
        TreeSet<Integer> set2 = new TreeSet<>(); // new에서 타입 파라미터 생략 가능
        TreeSet<Integer> set3 = new TreeSet<Integer>(set1); // set1의 모든 값을 가진 TreeSet 생성
        TreeSet<Integer> set4 = new TreeSet<Integer>(Arrays.asList(1,2,3)); // 초기값 지정

        // ⭐ TreeSet 값 추가 : add(value) 메소드
        TreeSet<Integer> set = new TreeSet<Integer>(); // TreeSet 생성
        set.add(7); // 값 추가
        set.add(4);
        set.add(9);
        set.add(1);
        set.add(5);

        // ⭐ TreeSet 값 삭제 : remove(value) 메소드 / clear() 메소드
        TreeSet<Integer> sets = new TreeSet<Integer>(Arrays.asList(1,2,3)); // TreeSet 생성
        sets.remove(1); // 값 1 제거
        sets.clear(); // 모든 값 제거

        // ⭐ TreeSet 크기 구하기 : size() 메소드
        TreeSet<Integer> set7 = new TreeSet<Integer>(Arrays.asList(1,2,3)); // TreeSet 생성 - 초기값 지정
        System.out.println(set7.size()); // set 크기 : 3

        // ⭐ TreeSet 값 출력 : first() / last() / higher(value) / lower(value)
        TreeSet<Integer> set8 = new TreeSet<Integer>(Arrays.asList(4,2,3)); // 초기값 지정
        System.out.println(set8); // 전체 출력 : [2,3,4]
        System.out.println(set8.first()); // 최소값 출력
        System.out.println(set8.last()); // 최대값 출력
        System.out.println(set8.higher(3)); // 입력값보다 큰 데이터 중 최소값 출력, 없으면 null
        System.out.println(set8.lower(3)); // 입력값보다 작은 데이터 중 최대값 출력, 없으면 null
        System.out.println(set8.ceiling(3)); // 입력값이랑 같거나, 큰 데이터 중 최소값 출력, 없으면 null
        System.out.println(set8.floor(3)); // 입력값이랑 같거나, 작은 데이터 중 최대값 출력, 없으면 null

        while(!set8.isEmpty()) { // isEmpty()
            System.out.println(set8.pollFirst()); // pollFirst()
        }
        System.out.println("set8이 비었습니다.");

        // 반복자(Iterator), iterator() 메서드, hasNext(), next()
        Iterator iter = set8.iterator(); // Iterator 사용
        while(iter.hasNext()) { // 값이 있으면 true, 없으면 false
            System.out.println(iter.next());
        }

    }
}
