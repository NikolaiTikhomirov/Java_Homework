import java.util.Arrays;

public class Homework {
    public static void main(String[] args) throws Exception {
        System.out.println(isSumBetween10And20(5, 15)); // true
        System.out.println(isSumBetween10And20(7, 15)); // false
        System.out.println(isSumBetween10And20(2, 6)); // false

        System.out.println(isPositive(5)); // true
        System.out.println(isPositive(-3)); // false

        printString("abcd", 5); // abcdabcdabcdabcdabcd

        System.out.println(isLeapYear(2023));
        System.out.println(isLeapYear(2024));
        System.out.println(isLeapYear(2000));
        System.out.println(isLeapYear(2100));

        // printArray(createArray(5, 7));
        System.out.println(Arrays.toString(createArray(5, 7)));
      
        
    //  * 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    //  * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;

    int array1 [] = new int [] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
    for (int i = 0; i < array1.length; i++) {
        if (array1 [i] == 1) array1 [i] = 0;
        else if (array1 [i] == 0) array1 [i] = 1;
    }
    System.out.println(Arrays.toString(array1));

    //  * 2. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;

    int array2 [] = new int [] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    for (int i = 0; i < array2.length; i++) {
        if (array2 [i] < 6) array2 [i] = array2 [i] * 2;
    }
    System.out.println(Arrays.toString(array2));
    
    //  * 3. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    //  * и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
    //  * Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
 
    int[][] array3 = new int[4][4]; // [[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, x], [0, 0, 0, 1]]
    // int x = array[2][3];

    for (int i = 0; i < array3.length; i++) {
        array3[i][i] = 1;
    }
    for (int i = 0; i < array3.length; i++) {
        System.out.println(Arrays.toString(array3[i]));
    }
    int[][] array4 = new int[4][4];


    System.out.println();
    //  * * Также заполнить элементы побочной диагонали

    for (int i = 0; i < array4.length; i++) {
        array4[i][array4.length - 1 - i] = 1;
    }
    for (int i = 0; i < array4.length; i++) {
        System.out.println(Arrays.toString(array4[i]));
    }

}

    /**
     * 1. Написать метод, принимающий на вход два целых числа и проверяющий,
     * что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
     */
    private static boolean isSumBetween10And20(int a, int b) {
        // проверить, что сумма a и b лежит между 10 и 20
        if ((a + b >= 10) & (a + b <= 20)) return true;
        return false;
    }

    private static boolean isPositive(int x) {
        // проверить, что х положительное
        if (x >= 0) return true;
        return false;
    }

    private static void printString(String source, int repeat) {
        // напечатать строку source repeat раз
        String res = "";
        for (int i = 0; i < repeat; i++) {
            res = res + source;
        }
        System.out.println(res);
    }

    private static boolean isLeapYear(int year) {
        // проверить, является ли год високосным. если да - return true
        // год является високосным, если он делится на 4, но не делится на 100, но делится на 400
        if (year % 4 == 0 ^ (year % 100 == 0 && year % 400 != 0)) return true;
        return false;
    }

    private static int[] createArray(int len, int initialValue) {
        // должен вернуть массив длины len, каждое значение которого равно initialValue
        int resArray [] = new int [len];
        for (int i = 0; i < resArray.length; i++) {
            resArray[i] = initialValue;
        }
        return resArray;
    }
    
}
