import java.util.*;

public class Stream {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Alice", "Jane", "Bob");

        List<String> filtered = names.stream()
            .filter(name -> name.startsWith("J"))
            .map(String::toUpperCase)
            .toList();

        System.out.println(filtered); // [JOHN, JANE]
    }
}