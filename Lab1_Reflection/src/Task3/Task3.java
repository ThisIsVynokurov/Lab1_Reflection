package Task3;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

class Task3 {

    public static Object invokeMethod(Object object, String methodName, Object[] parameters) throws FunctionNotFoundException {
        Class<?> objClass = object.getClass();
        Class<?>[] parameterTypes = new Class[parameters.length];

        for (int i = 0; i < parameters.length; i++) {
            parameterTypes[i] = listOfPrimitiveClasses (parameters[i].getClass());
        }

        try {
            Method method = objClass.getMethod(methodName, parameterTypes);
            return method.invoke(object, parameters);
        } catch (NoSuchMethodException | InvocationTargetException e) {
            throw new FunctionNotFoundException("Метод не було знайдено: " + e.getMessage());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static Class<?> listOfPrimitiveClasses (Class<?> classChoice) {
        if (classChoice == Integer.class) return int.class;
        if (classChoice == Double.class) return double.class;
        if (classChoice == Long.class) return long.class;
        if (classChoice == Short.class) return short.class;
        if (classChoice == Float.class) return float.class;
        if (classChoice == Boolean.class) return boolean.class;
        if (classChoice == Byte.class) return byte.class;
        if (classChoice == Character.class) return char.class;
        return classChoice;
    }

    public static void main(String[] args) {
        try {
            TestClass testObj = new TestClass(1.0);
            Object[] params1 = {1.0};
            System.out.println("Типи: [double], значення: [1]");
            System.out.println("Результат виклику: " + invokeMethod(testObj, "testMethod", params1));

            Object[] params2 = {1.0, 1};
            System.out.println("Типи: [double, int], значення: [1, 1]");
            System.out.println("Результат виклику: " + invokeMethod(testObj, "testMethod", params2));
        } catch (FunctionNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}