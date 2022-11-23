import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Collection<Integer> integerCollection = Arrays.asList(1, 1, 2, 3, 4, 5, 6);
        Collection<String> stringCollection = Arrays.asList("Input", "Output", "Outperform", "Intrade", "Outrun");
        Collection<String> smallStringCollection = Arrays.asList("Input");
        Collection<String> mapStringCollection = Arrays.asList("Input", "Output");

        System.out.println("getAverage: " + Streamable.getAverage(integerCollection));
        System.out.println("getSquare: " + Streamable.getSquare(integerCollection));
        System.out.println("getSum: " + Streamable.getSum(integerCollection));
        System.out.println("getUpperString: " + Streamable.getUpperString(stringCollection));
        System.out.println("getSorted: " + Streamable.getSorted(stringCollection, "Out"));
        System.out.println("findLast: " + Streamable.findLast(stringCollection));
        System.out.println("findLast: " + Streamable.findLast(smallStringCollection));
        System.out.println("convertToMap: " + Streamable.convertToMap(mapStringCollection));
    }
}