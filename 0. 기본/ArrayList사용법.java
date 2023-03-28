import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayList사용법 {

    public static void main(String[] args) {

        // ⭐ ArrayList 선언 : ArrayLIst<String> list = new ArrayList<>();
        ArrayList arrayList = new ArrayList(); // 타입 미설정, Object로 선언된다.
        ArrayList<Student> member = new ArrayList<Student>(); // 타입설정, Student객체만 사용 가능
        ArrayList<Integer> num = new ArrayList<Integer>(); // 타입설정, int타입만 사용 가능
        ArrayList<Integer> num2 = new ArrayList<>(); // new에서 타입 파라미터 생략 가능
        ArrayList<Integer> num3 = new ArrayList<Integer>(10); // 초기 용량(capacity) 지정
        ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1,2,3)); // 생성 시 값 추가

        // ⭐ ArrayList 값 추가 : add(index, value) 메소드
        // index를 생략하면 ArrayList 맨 뒤에 데이터가 추가되며, index 중간에 값을 추가하면 해당 인덱스부터 마지막 인덱스까지 모두 1씩 뒤로 밀려납니다.
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3); // 값 추가
        list.add(null); // null값도 add 가능
        list.add(1,10); // index 1에 10 삽입

        ArrayList<Student> members = new ArrayList<Student>();
        Student student = new Student("김예은", 24);
        members.add(student);
        members.add(new Student("홍길동", 15));

        // ⭐ ArrayList 값 삭제 : remove(index) 메소드 / clear()
        ArrayList<Integer> listlist = new ArrayList<Integer>(Arrays.asList(1,2,3));
        listlist.remove(1); // index 1 제거
        listlist.clear(); // 모든 값 제거

        // ⭐ ArrayList 크기 구하기 : list.size()
        ArrayList<Integer> listSize = new ArrayList<Integer>(Arrays.asList(1,2,3));
        System.out.println(listSize.size()); // list 크기 : 3

        // ⭐ ArrayList 값 출력 : get(index)
        ArrayList<Integer> alist = new ArrayList<Integer>(Arrays.asList(1,2,3));

        System.out.println(alist.get(0)); // 0번째 index 출력

        for(Integer i : alist) { // for문을 통한 전체 출력
            System.out.println(i);
        }

        Iterator iter = alist.iterator(); // Iterator 선언
        while(iter.hasNext()){ // 다음값이 있는지 체크
            System.out.println(iter.next()); // 값 출력
        }

        // ⭐ ArrayList 값 검색 : contains(value) / indexOf(value)
        ArrayList<Integer> arrlist = new ArrayList<Integer>(Arrays.asList(1,2,3));
        System.out.println(arrlist.contains(1)); // list에 1이 있는지 검색 : true
        System.out.println(arrlist.indexOf(1)); // 1이 있는 index 반환, 없으면 -1

    }
}

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
