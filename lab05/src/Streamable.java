import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.List;

public class Streamable {
    public static double getAverage(List<Integer> collection) {
        return collection.stream().mapToInt(x -> x).average().getAsDouble();
    }

    public static Collection<String> getUpperString(List<String> collection) {
        return collection.stream().map(String::toUpperCase).map(x -> "_new_" + x).collect(Collectors.toList());
    }

    public static List<Integer> getSquare(List<Integer> collection) {
        return collection.stream().filter(x -> collection.stream().filter(y -> y.equals(x)).count() == 1).map(x -> x * x).collect(Collectors.toList());
    }

    public static List<String> getSorted(Collection<String> collection, String target) {
        return collection.stream().filter(x -> x.startsWith(target)).sorted().collect(Collectors.toList());
    }

    public static String findLast(Collection<String> collection) {
        return collection.stream().reduce((x, y) -> y).orElseThrow();
    }

    public static int getSum(Integer[] collection) {
        return Arrays.stream(collection).filter(x -> x % 2 == 0).reduce(Integer::sum).orElse(0);
    }

    public static Map<String, String> convertToMap(List<String> collection) {
        return collection.stream().collect(Collectors.toMap(x -> x.substring(0, 1), x -> x.substring(1)));
    }
}
