package Task3;

class TestClass {
    private final double a;

    public TestClass(double a) {
        this.a = a;
    }

    public double testMethod(double x) {
        return Math.exp(-Math.abs(a) * x) * Math.sin(x);
    }

    public double testMethod(double x, int multiplier) {
        return Math.exp(-Math.abs(a) * x * multiplier) * Math.sin(x * multiplier);
    }
}