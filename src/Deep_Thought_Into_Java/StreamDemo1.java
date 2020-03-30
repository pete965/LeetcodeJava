package Deep_Thought_Into_Java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StreamDemo1 {
    public static void main(String[] args) {
        List<String> nameStrs = Arrays.asList("Monkey","Lion","Giraffe","Lemur");
        List<String> list = nameStrs.stream()
                .filter(s -> s.startsWith("L"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
    }
}
