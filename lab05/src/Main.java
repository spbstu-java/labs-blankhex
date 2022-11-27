import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 1, 2, 3, 4, 5, 6);
        System.out.println("getAverage: " + Streamable.getAverage(integerList));
        System.out.println("getSquare: " + Streamable.getSquare(integerList));

        Integer[] integerArray = new Integer[]{1, 1, 2, 3, 4, 5, 6};
        System.out.println("getSum: " + Streamable.getSum(integerArray));

        List<String> stringList = Arrays.asList("Input", "Output", "Outperform", "Intrade", "Outrun");
        System.out.println("getUpperString: " + Streamable.getUpperString(stringList));

        Collection<String> stringCollection = Arrays.asList("Input", "Output", "Outperform", "Intrade", "Outrun");
        System.out.println("getSorted: " + Streamable.getSorted(stringCollection, "Out"));
        System.out.println("findLast: " + Streamable.findLast(stringCollection));

        Collection<String> smallStringCollection = Arrays.asList("Input");
        System.out.println("findLast: " + Streamable.findLast(smallStringCollection));
        try {
            Collection<String> emptyStringCollection = Arrays.asList();
            System.out.println("findLast: " + Streamable.findLast(emptyStringCollection));
        } catch(Exception e) {
            System.out.println("findLast: throwed exception");
        }

        List<String> mapStringList = Arrays.asList("Input", "Output");
        System.out.println("convertToMap: " + Streamable.convertToMap(mapStringList));
    }
}