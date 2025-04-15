import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class filters {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "John", "Jane", "Bob");
        List<String> result = names.stream()
        .filter(name -> name.startsWith("J")) // 이 조건에 맞는 요소만 filter
        .toList();
        // Predicate<T> = T -> boolean 조건에 맞는 값만 통과

        System.out.println(result);

        //  List 안의 List 
        List<List<String>> nested = List.of(
            List.of("a", "b"),
            List.of("c")
        );

        List<String> flat = nested.stream()
        .flatMap(List::stream) // 내부 리스트 펼치기 메소드 리퍼런스
        .toList();
        // Function<T, Stream<R>> 
        // T -> List<String>
        // R -> String
        System.out.println(flat);

        List<String> words = List.of("apple", "banana", "avocado", "blueberry");

        Map<Character, List<String>> grouped = words.stream()
        // collect() 스트림 연산의 최종 결과를 만드는 함수
        // 분류 기준으로 그룹핑
        .collect(Collectors.groupingBy(word -> word.charAt(0))); 

        System.out.println(grouped);
        // Map<K, List<T>>

    }
}
