import java.lang.reflect.Method;

public class Main {
    /* Написать аннотацию с целочисленным параметром. Создать класс, содержащий публичные, защищенные и приватные методы
    * аннотировать любые из них. Вызвать из другого класса все аннотированные защищенные и приватные методы столько раз,
    * сколько указано в параметре аннотации */
    public static void main(String[] args) {
        ExampleClass exampleClass = new ExampleClass();

        Method[] methods = exampleClass.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(PolytechAnnotation.class) == true) {
                PolytechAnnotation annotation = method.getAnnotation(PolytechAnnotation.class);
                int n = annotation.n();

                try {
                    for (int i = 0; i < n; i++) {
                        method.invoke(exampleClass);
                    }
                } catch (Exception exception) {
                    System.err.println(exception.toString());
                }
            }
        }

        System.out.println("Hello world!");
    }
}