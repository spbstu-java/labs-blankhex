import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Tranlator tranlator = new Tranlator();

        try {
            tranlator.load("dict.txt");
            tranlator.translate("input.txt", System.out);
        } catch (IOException exception) {
            System.err.println("Exception: " + exception.toString());
        }
    }
}