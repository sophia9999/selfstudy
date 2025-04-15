import java.util.*;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Alice", "Jane", "Bob");

        List<String> filtered = names.stream()
            .filter(name -> name.startsWith("J"))
            .map(String::toUpperCase) 
            // name -> name.toUpperCase() 로 자동 변환해준다. 
            // <R> Stream<R> map(Function<? super T, ? extends R> var1); --> 해당 API 때문임.
            // <R> 이란 이 메서드 안에서 R이라는 타입을 쓴다는 제네릭 타입 매개변수 선언이다.
            // Stream<R>은 리턴 타입이다. var1가 받는 매개변수임.
            // var1은 T를 받아서 R로 바꿔주는 함수를 담고 있는 매개변수
            // map(String::toUpperCase) → T=String, R=String 
            .toList();

        System.out.println(filtered); // [JOHN, JANE]

        Stream<String> strings = Stream.of("apple", "banana");
        strings.map(String::toUpperCase) 
                // Function<String, String>에 해당하는 메서드 레퍼런스
                // 문자열 하나를 받아 대문자로 바꿔주는 함수 객체로 해석됨
               .forEach(System.out::println);

        Stream<Integer> numbers = Stream.of(1, 2, 3);
        numbers.map(String::valueOf)  
                // Function<Integer, String> 
                // 정수 값을 받아서 문자열로 변환하는 String.valueOf(int)를 참조한 형태
               .forEach(System.out::println);

        // Stream<T>에서 시작 → map(Function<T, R>) 적용 → Stream<R>로 변환
    }
}