package Task5;

import java.lang.reflect.Proxy;

public class Task5 {
    public static void main(String[] args) {
        Evaluatable first = new FirstFunction(2.5);
        Evaluatable second = new SecondFunction();

        Evaluatable firstPrProxy = (Evaluatable) Proxy.newProxyInstance(
                Evaluatable.class.getClassLoader(),
                new Class[]{Evaluatable.class},
                new TimePrInvocationHandler (first)
        );

        Evaluatable secondTrProxy = (Evaluatable) Proxy.newProxyInstance(
                Evaluatable.class.getClassLoader(),
                new Class[]{Evaluatable.class},
                new TimeTrInvocationHandler(second)
        );

        System.out.println("F1: " + first.evalf(0.0069072144));
        System.out.println("F2: " + second.evalf(1.0));

        System.out.println("F1: " + firstPrProxy.evalf(0.0));
        System.out.println("F2: " + secondTrProxy.evalf(1.0));
    }
}