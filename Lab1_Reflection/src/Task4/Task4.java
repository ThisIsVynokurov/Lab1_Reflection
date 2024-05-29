package Task4;

import java.lang.reflect.Array;

public class Task4 {

    public static Object matrixCreation (Class<?> compType, int rows, int columns) {
        return Array.newInstance(compType, rows, columns);
    }

    public static Object arrayCreation (Class<?> compType, int length) {
        return Array.newInstance(compType, length);
    }

    public static Object changeSizeArray (Object array, int changedLength) {
        Class<?> componentType = array.getClass().getComponentType();
        Object changedArray = Array.newInstance(componentType, changedLength);
        System.arraycopy(array, 0, changedArray, 0, Math.min(Array.getLength(array), changedLength));
        return changedArray;
    }

    public static Object changeSizeMatrix (Object matrix, int changedRows, int changedColumns) {
        int previousRows = Array.getLength(matrix);
        int previousColumns = Array.getLength(Array.get(matrix, 0));
        Class<?> componentType = matrix.getClass().getComponentType().getComponentType();

        Object changedMatrix = Array.newInstance(componentType, changedRows, changedColumns);
        for (int i = 0; i < Math.min(previousRows, changedRows); i++) {
            Object previousRow = Array.get(matrix, i);
            Object changedRow = Array.newInstance(componentType, changedColumns);
            System.arraycopy(previousRow, 0, changedRow, 0, Math.min(previousColumns, changedColumns));
            Array.set(changedMatrix, i, changedRow);
        }
        return changedMatrix;
    }

    public static String fromArrayToString (Object array) {
        int length = Array.getLength(array);
        StringBuilder build = new StringBuilder();
        build.append(array.getClass().getComponentType().getTypeName());
        build.append("[");
        build.append(length);
        build.append("] = {");
        for (int i = 0; i < length; i++) {
            build.append(Array.get(array, i));
            if (i < length - 1) {
                build.append(", ");
            }
        }
        build.append("}");
        return build.toString();
    }

    public static String fromMatrixToString (Object matrix) {
        int rows = Array.getLength(matrix);
        int columns = Array.getLength(Array.get(matrix, 0));
        StringBuilder build = new StringBuilder();
        build.append(matrix.getClass().getComponentType().getComponentType().getTypeName());
        build.append("[");
        build.append(rows);
        build.append("][");
        build.append(columns);
        build.append("] = {");
        for (int i = 0; i < rows; i++) {
            build.append("{");
            Object row = Array.get(matrix, i);
            for (int j = 0; j < columns; j++) {
                build.append(Array.get(row, j));
                if (j < columns - 1) {
                    build.append(", ");
                }
            }
            build.append("}");
            if (i < rows - 1) {
                build.append(", ");
            }
        }
        build.append("}");
        return build.toString();
    }

    public static void main(String[] args) {

        int[] intArray = (int[]) arrayCreation (int.class, 2);
        System.out.println(fromArrayToString(intArray));

        String[] stringArray = (String[]) arrayCreation (String.class, 3);
        System.out.println(fromArrayToString(stringArray));

        Double[] doubleArray = (Double[]) arrayCreation (Double.class, 5);
        System.out.println(fromArrayToString(doubleArray));

        int[][] intMatrix = (int[][]) matrixCreation (int.class, 3, 5);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                intMatrix[i][j] = i * 10 + j;
            }
        }
        System.out.println(fromMatrixToString(intMatrix));

        intMatrix = (int[][]) changeSizeMatrix (intMatrix, 4, 6);
        System.out.println(fromMatrixToString(intMatrix));

        intMatrix = (int[][]) changeSizeMatrix (intMatrix, 3, 7);
        System.out.println(fromMatrixToString(intMatrix));

        intMatrix = (int[][]) changeSizeMatrix (intMatrix, 2, 2);
        System.out.println(fromMatrixToString(intMatrix));

        intMatrix = (int[][]) changeSizeMatrix (intMatrix, 5, 3);
        System.out.println(fromMatrixToString(intMatrix));
    }
}