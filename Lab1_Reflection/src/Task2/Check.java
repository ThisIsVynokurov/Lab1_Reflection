package Task2;

public class Check {
    private double x;
    private double y;

    public Check(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double Dist() {
        return Math.sqrt(x * x + y * y);
    }

    public void setRandomData() {
        this.x = Math.random();
        this.y = Math.random();
    }


    @Override
    public String toString() {
        return "Check{x=" + x + ", y=" + y + "}";
    }
}