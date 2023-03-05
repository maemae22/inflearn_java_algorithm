import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMap사용법 {

    public static void main(String[] args) {

        // ⭐ HashMap 선언
        HashMap<String,String> map1 = new HashMap<String,String>(); // HashMap 생성
        HashMap<String,String> map2 = new HashMap<>(); // new에서 타입 파라미터 생략 가능
        HashMap<String,String> map3 = new HashMap<>(map1); // map1의 모든 값을 가진 HashMap 생성

        HashMap<String,String> map4 = new HashMap<>(10); // 초기 용량(capacity) 지정
        HashMap<String,String> map5 = new HashMap<>(10, 0.7f); // 초기 capacity, load factor 지정
        HashMap<String,String> map6 = new HashMap<String,String>(){{ // 초기값 지정
            put("a","b");
        }};


        // ⭐ HashMap 값 추가 : put(key,value) 메소드
        HashMap<Integer,String> map = new HashMap<>(); // new에서 타입 파라미터 생략 가능
        map.put(1, "사과"); // 값 추가
        map.put(2, "바나나");
        map.put(3, "포도");


        // ⭐ HashMap 값 삭제 : remove(key) - 오직 키값으로만 Map의 요소를 삭제할 수 있음
        //                     clear() - 모든 값을 제거
        map.remove(1); // key값이 1인 것 제거
        map.clear(); // 모든 값 제거

        // ⭐ 두 HashMap의 비교 : equals()
        System.out.println(map1.equals(map2));

        // ⭐ HashMap 값 출력
        map.put(1, "사과"); // 값 추가
        map.put(2, "바나나");
        map.put(3, "포도");

        System.out.println(map); // 전체 출력 : {1=사과, 2=바나나, 3=포도} (Map의 전체 key값, value가 출력)
        System.out.println(map.get(1)); // key값이 1인 것의 value 얻기 : 사과 (특정 key값의 value를 가져오고싶다면 get(key)를 사용)

        // Map 전체 출력 - entrySet()이나 keySet() 메서드를 활용
        // key값을 이용해서 value를 찾는 과정에서 시간이 많이 소모되므로
        // 많은 양의 데이터를 가져와야 한다면 entrySet()이 좋음 (약 20%~200% 성능 저하가 있음)

        // 1. entrySet() 활용 : key와 value 모두가 필요할 경우 사용
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("[Key]:" + entry.getKey() + " [Value]:" + entry.getValue());
        }
        //[Key]:1 [Value]:사과
        //[Key]:2 [Value]:바나나
        //[Key]:3 [Value]:포도

        // 2. keySet() 활용 : key 값만 필요할 경우 사용
        for(Integer i : map.keySet()){ // 저장된 key값 확인
            System.out.println("[Key]:" + i + " [Value]:" + map.get(i));
        }
        //[Key]:1 [Value]:사과
        //[Key]:2 [Value]:바나나
        //[Key]:3 [Value]:포도


        // ⭐ Iterator 사용 : HashMap의 전체출력 시 반복문을 사용하지 않고 Iterator를 사용하는 방법
        // 1. entrySet().iterator()
        Iterator<Map.Entry<Integer, String>> entries = map.entrySet().iterator();
        while(entries.hasNext()){
            Map.Entry<Integer, String> entry = entries.next();
            System.out.println("[Key]:" + entry.getKey() + " [Value]:" +  entry.getValue());
        }
        //[Key]:1 [Value]:사과
        //[Key]:2 [Value]:바나나
        //[Key]:3 [Value]:포도

        // 2. keySet().iterator()
        Iterator<Integer> keys = map.keySet().iterator();
        while(keys.hasNext()){
            int key = keys.next();
            System.out.println("[Key]:" + key + " [Value]:" +  map.get(key));
        }
        //[Key]:1 [Value]:사과
        //[Key]:2 [Value]:바나나
        //[Key]:3 [Value]:포도

    }
}
