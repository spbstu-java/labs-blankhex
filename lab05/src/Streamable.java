import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Map;

public class Streamable {
    public static double getAverage(Collection<Integer> collection) {
        return collection.stream().mapToInt(x -> x).average().getAsDouble();
    }

    public static Collection<String> getUpperString(Collection<String> collection) {
        return collection.stream().map(String::toUpperCase).map(x -> "_new_" + x).collect(Collectors.toList());
    }

    public static Collection<Integer> getSquare(Collection<Integer> collection) {
        return collection.stream().filter(x -> collection.stream().filter(y -> y.equals(x)).count() == 1).map(x -> x * x).collect(Collectors.toList());
    }

    public static Collection<String> getSorted(Collection<String> collection, String target) {
        return collection.stream().filter(x -> x.startsWith(target)).sorted().collect(Collectors.toList());
    }

    public static String findLast(Collection<String> collection) {
        return collection.stream().reduce((x, y) -> y).orElse("");
    }

    public static int getSum(Collection<Integer> collection) {
        return collection.stream().filter(x -> x % 2 == 0).reduce(Integer::sum).orElse(0);
    }

    public static Map<String, String> convertToMap(Collection<String> collection) {
        return collection.stream().collect(Collectors.toMap(x -> x.substring(0, 1), x -> x.substring(1)));
    }
}
