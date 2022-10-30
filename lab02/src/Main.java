import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static Matrix readMatrix(String filepath) throws FileNotFoundException, ArgumentTooLargeException {
        try (FileReader fileReader = new FileReader(filepath); Scanner scanner = new Scanner(fileReader)) {
            int n = scanner.nextInt();
            return Matrix.create(n);
        } catch (IOException e) {
            throw new FileNotFoundException(filepath);
        }
    }


    public static void main(String[] args) {
        Logger logger = Logger.getLogger("Application");

        try (FileOutputStream file = new FileOutputStream("output.txt");
             PrintStream stream = new PrintStream(file)) {
            Matrix matrix = readMatrix("input.txt");

            matrix.print(stream);

            for (int i = 0; i < 3; ++i) {
                matrix = matrix.rotate();
                try {
                    Matrix result = matrix.divide();
                    stream.println("---------");
                    result.print(stream);
                } catch (DivisionByZeroException e) {
                    logger.log(Level.WARNING, "Division by 0");
                }
            }
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "File not found: " + e.toString());
        } catch (ArgumentTooLargeException e) {
            logger.log(Level.SEVERE, "Argument too large: " + e.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (OutOfMemoryError e) {
            logger.log(Level.SEVERE, "Out of Memory");
        }
    }
}