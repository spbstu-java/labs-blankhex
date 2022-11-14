public class FileNotFoundException extends RuntimeException {
    public FileNotFoundException() {
        super("Файл не найден");
    }

    public FileNotFoundException(String filepath) {
        super("Файл '" + filepath + "' не найден");
    }
}
