public class ExampleClass {
    @PolytechAnnotation(n = 1)
    private void x1() {
        System.out.println("x1()");
    }

    private void x2() {
        System.out.println("x2()");
    }

    @PolytechAnnotation(n = 3)
    public void y1() {
        System.out.println("y1()");
    }

    public void y2() {
        System.out.println("y2()");
    }

    protected void z1() {
        System.out.println("z1()");
    }

    @PolytechAnnotation(n = 2)
    protected void z2() {
        System.out.println("z2()");
    }
}
