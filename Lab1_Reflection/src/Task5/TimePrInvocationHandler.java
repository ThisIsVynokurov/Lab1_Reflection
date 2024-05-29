package Task5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TimePrInvocationHandler implements InvocationHandler {
    private final Evaluatable obj;

    public TimePrInvocationHandler (Evaluatable obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.nanoTime();
        Object result = method.invoke(obj, args);
        long endTime = System.nanoTime();
        System.out.println("1)." + obj.getClass().getSimpleName() + ":(exp(-|a|*x)*sin(x))." + method.getName() + (args != null ? "(" + Arrays.toString(args) + ")" : "") + " took " + (endTime - startTime) + " ns");
        return result;
    }
}