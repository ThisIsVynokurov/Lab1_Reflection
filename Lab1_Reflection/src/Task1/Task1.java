package Task1;

import java.lang.reflect.*;
import java.util.Arrays;

public class Task1 {

    public static String analyzeClass(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            return analyzeClass(clazz);
        } catch (ClassNotFoundException e) {
            return "Клас не було знайдено: " + className;
        }
    }

    public static String analyzeClass(Class<?> findClassInf) {
        StringBuilder getResult = new StringBuilder();

        Package pkg = findClassInf.getPackage();
        if (pkg != null) {
            getResult.append("package ").append(pkg.getName());
            getResult.append(", Java Platform API Specification, version 1.7\n");
        } else {
            getResult.append("default package\n");
        }

        getResult.append(Modifier.toString(findClassInf.getModifiers())).append(" ");
        getResult.append(findClassInf).append("\n");

        Class<?> superclass = findClassInf.getSuperclass();
        if (superclass != null) {
            getResult.append("extends ").append(superclass.getName()).append(" ");
        }

        Class<?>[] interfaces = findClassInf.getInterfaces();
        if (interfaces.length > 0) {
            getResult.append("implements ");
            for (int i = 0; i < interfaces.length; i++) {
                getResult.append(interfaces[i].getName());
                if (i < interfaces.length - 1) {
                    getResult.append(", ");
                }
            }
            getResult.append(" ");
        }
        getResult.append("{\n");

        Field[] fields = findClassInf.getDeclaredFields();
        getResult.append("// Поля\n");
        for (Field field : fields) {
            getResult.append("  ");
            getResult.append(Modifier.toString(field.getModifiers())).append(" ");
            getResult.append(field.getType().getName()).append(" ");
            getResult.append(field.getName()).append(";\n");
        }

        Constructor<?>[] constructors = findClassInf.getDeclaredConstructors();
        getResult.append("// Конструктори\n");
        for (Constructor<?> constructor : constructors) {
            getResult.append("  ");
            getResult.append(Modifier.toString(constructor.getModifiers())).append(" ");
            getResult.append(constructor.getName()).append(Arrays.toString(constructor.getParameterTypes())).append(";\n");
        }

        Method[] methods = findClassInf.getDeclaredMethods();
        getResult.append("// Методи\n");
        for (Method method : methods) {
            getResult.append("  ");
            getResult.append(Modifier.toString(method.getModifiers())).append(" ");
            getResult.append(method.getReturnType().getName()).append(" ");
            getResult.append(method.getName()).append(Arrays.toString(method.getParameterTypes())).append(";\n");
        }

        getResult.append("}");
        return getResult.toString();
    }
}
