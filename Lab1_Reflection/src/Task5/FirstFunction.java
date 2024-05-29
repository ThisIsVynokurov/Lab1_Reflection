package Task5;

public class FirstFunction implements Evaluatable{
    private double a;

    public FirstFunction(double a){
        this.a = a;
    }

    @Override
    public double evalf (double x){
        return Math.exp(-Math.abs(a) * x) * Math.sin(x);
    }
}
